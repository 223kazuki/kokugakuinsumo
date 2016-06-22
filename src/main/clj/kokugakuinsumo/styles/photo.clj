(ns kokugakuinsumo.styles.photo
  (:require [garden.stylesheet :refer [at-media]]))

(def styles
  [:#photo
   [:a {:border-radius "0px"}]
   [:#lightgallery
    [:img {:width "24%"
           :margin "3px"
           :overflow "hidden"}
     [:&.image
      {:opacity  "0"
       :transition  "opacity 0.3s"}]
     [:&.image-loaded
      {:opacity "1"
       :-moz-transition "-moz-transform 1s linear"
       :-webkit-transition "-webkit-transform 1s linear"
       :-o-transition "-o-transform 1s linear"
       :-ms-transition "-ms-transform 1s linear"
       :transition "transform 0.1s linear"}
      [:&:hover
       {:-webkit-transform "scale(1.04)"
        :-moz-transform "scale(1.04)"
        :-o-transform "scale(1.04)"
        :-ms-transform "scale(1.04)"
        :transform "scale(1.04)"}]]]]
   [:.picasa
    {:margin-top "10px"
     :height "50px"
     :vertical-align "middle"
     :background-image "url(/images/picasa.svg)"
     :background-size "100px 100px"
     :background-position "3% 50%"
     :background-color "#f0f0f0"
     :border-radius "5px"
     :background-repeat "no-repeat"}]
   (at-media {:screen true :max-width "750px"}
             [:#lightgallery
              [:img {:width "49%"
                     :margin "1px"}]])])
