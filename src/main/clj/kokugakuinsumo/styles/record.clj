(ns kokugakuinsumo.styles.record
  (:require [garden.stylesheet :refer [at-media]]))

(def styles
  [:#record
   {:font-size "15px"}
   [:p {:font-size "18px"
        :margin-left "10px"}]
   [:.tab {:margin-top "10px"}]
   [:h2 {:margin-top "-3px"}
    [:span.attribute
     {:margin-left "20px"
      :font-size "70%"
      :color "#ccc"
      :position "relative"
      :top "0px"}]]
   [:.game {:font-size "18px"
            :margin-bottom "-10px"}
    [:.win {:background-color "#fadbda"}]
    [:h3 {:margin-top "-3px"
          :font-size "20px"}]]

   (at-media {:screen true :max-width "750px"}
             {:font-size "13px"}
             [:.game {:font-size "13px"}
              [:h3 {:margin-top "-3px"
                    :font-size "20px"}]])])
