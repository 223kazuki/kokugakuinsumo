(ns kokugakuinsumo.views.linklist
  (:require [reagent.core :refer [create-class]]
            [re-frame.core :refer [dispatch
                                   subscribe]]
            [kokugakuinsumo.views.components :as c]))

(defn linklist-page []
  (create-class
    {:component-will-mount
     (fn []
       (dispatch [:get-links]))
     :reagent-render
     (fn []
       (let [links @(subscribe [:links])]
         [:div {:id "linklist"}
          [c/row
           [c/col {:xs 12 :md 12}
            [:h1 "リンク集"]]
           (when-not (nil? links)
             [c/col {:xs 12 :md 12 :id "linkBody"}
              (for [l links]
                [c/col {:xs 12 :md 12 :id "linkBody" :key (:name l)}
                 [c/thumbnail
                  [c/row
                   [c/col {:xs 12 :md 12}
                    [:a {:href (:link l)}
                     [:img {:class "thumbnail" :src (:src l) :alt (:alt l) :width (:width l)}]]]
                   [c/col {:xs 12 :md 12 :class "information"}
                    [:h3 [:a {:href (:link l)} (:name l)]]
                    (:information l)]]]])])]]))}))
