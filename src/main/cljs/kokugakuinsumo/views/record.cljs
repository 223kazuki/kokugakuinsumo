(ns kokugakuinsumo.views.record
  (:require [reagent.core :refer [create-class]]
            [re-frame.core :as r]
            [kokugakuinsumo.views.components :as c]))

(defn game-component [games]
  [c/row
   (for [g games]
     (let [win? (= (:result g) "win")
           individual? (= (:type g) "individual")]
       [c/col {:xs 12 :md 12 :class "game" :key (str (:tournament g) (:opponent g) (:turn g))}
        [c/thumbnail {:class (when win? "win")}
         [:h3 (str (if individual? "個人戦" "団体戦") " " (:game g))]
         (str (:player g) " ")
         [:svg {:width 34 :height 12}
          [:circle {:cx 6 :cy 6 :r 5 :fill (if win? "#ffffff" "#000000") :stroke "#000000" :strokeWidth 1}]
          [:line {:x1 14 :y1 6 :x2 20 :y2 6 :stroke "#000000" :strokeWidth 1}]
          [:circle {:cx 28 :cy 6 :r 5 :fill (if-not win? "#ffffff" "#000000") :stroke "#000000" :strokeWidth 1}]]
         (str " " (:opponent g) "  " (if individual? (str "(" (:trick g) ")") (str "(" (:nwin g) "勝" (:nlose g) "負)")))]]))])

(defn record-tab [records]
  [c/row {:class "record"}
   (for [r records]
     [c/col {:xs 12 :md 12 :key (:date r)}
      [c/thumbnail {:class "record"}
       [:h2 (:tournament r)
        [:span {:class "attribute"} (str (:date r) "  " (:place r))]]
       [game-component (:games r)]]])])

(defn record-page []
  (create-class
    {:component-will-mount
     (fn []
       (r/dispatch [:get-records]))
     :reagent-render
     (fn []
       (let [datas @(r/subscribe [:records])]
         (when-not (nil? datas)
           [:div {:id "record"}

            [c/row
             [c/col {:xs 12 :md 12}
              [:h1 "歴代最高戦績"]
              [:h3 "東日本学生相撲新人選手権大会"]
              [:p "Cクラストーナメント準優勝（2014年度）"]
              [:h3 "全国学生相撲新人選手権大会"]
              [:p "Cクラストーナメント三位入賞（2014年度）"]
              [:h3 "東日本個人体重別選手権大会"]
              [:p "柳井 75kg未満級8位入賞（2013年度）"]
              [:h1 "年度別戦績"]]
             [c/col {:xs 12 :md 12}
              [c/tabs {:id "records" :defaultActiveKey 0}
               (some->> datas
                        (sort-by :year)
                        reverse
                        (map-indexed
                          (fn [i d]
                            [c/tab {:eventKey i :title (str (:year d) "年度") :key i}
                             [record-tab (:records d)]]))
                        doall)]]]])))}))
