(ns kokugakuinsumo.styles.linklist
  (:require [garden.stylesheet :refer [at-media]]))

(def styles
  [:#linklist
   [:.information
    {:padding-left 0}
    [:h3 {:font-size "15px"
          :border-bottom "1px solid #999999"
          :border-left "6px solid #3cf"
          :line-height "200%"
          :padding-left "8px"
          :margin-bottom "5px"}
     [:a:hover {:color "red"}]]]
   [:img {:margin-right 0
          :border 0}]
   (at-media {:screen true :max-width "750px"}
             [:.information
              {:padding-left "10px"}]
             [:img {:width "100%"}])])
