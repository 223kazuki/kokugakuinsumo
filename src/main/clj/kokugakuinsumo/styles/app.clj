(ns kokugakuinsumo.styles.app
  (:require [garden.stylesheet :refer [at-media]]))

(def styles
  [:#app
   [:#content-area
    [:.content-area-enter {:opacity 0.01
                           :transition "opacity .5s ease-in"}
     [:&.content-area-enter-active {:opacity 1}]]

    [:.content-area-leave {:opacity 1
                           :transition "opacity .5s ease-in"}
     [:&.content-area-leave-active {:opacity 0.01}]]

    [:a {:text-decoration "none"
         :color "black"
         :font-weight "bold"}
     [:&:hover {:color "#ff0306"}]
     [:&:visited {:color "black"}]]]

   [:header
    [:#title {:margin-left 0 :margin-right 0 :width "100%"
              :padding 0}
     [:.jumbotronLayer {:text-decoration "none"}
      [:&:hover {:text-decoration "none"}]
      [:.jumbotron {:cursor "pointer"
                    :border-radius 0
                    :margin 0
                    :margin-bottom "-50px"
                    :background-image "url(/images/jumbotron.jpg)"
                    :background-size "100%"
                    :background-position "center 30%"
                    :color "white"}
       [:h1 {:font-size "50px"
             :-webkit-text-stroke-color "#000"
             :-webkit-text-stroke-width "1px"}]
       [:p {:margin-left "5px"
            :margin-top "-5px"
            :font-size "20px"}]
       [:.social {:height "10px"}
        [:button {:text-align "right"
                  :font-size "15px"
                  :width "70px"
                  :padding-right "10px"
                  :background-repeat "no-repeat"
                  :border-radius "3px"
                  :border "none"}
         [:&.twitter {:margin-left "5px"
                      :background-color "#29AAE1"
                      :background-image "url(/images/webicon-twitter.svg)"}]
         [:&.facebook {:background-color "#293F7E"
                       :background-image "url(/images/webicon-facebook.svg)"}]]]]]]
    [:.navbar-custom {:border "none"
                      :background-color "rgba(0,0,0,0.5)"}
     [:.navbar-nav
      {:font-size "15px"
       :margin "0 auto"
       :display "table"
       :table-layout "fixed"
       :float "none"}
      [:li {:transition "background-color 0.3s"}
       [:&:hover {:background-color "rgba(255,255,255,0.3)"}]]]]]

   [:#sidebar
    [:aside {:background "#f0f0f0"
             :padding "20px"
             :margin-bottom "20px"}
     [:h2 {:margin-top "10px"
           :font-size "20px"
           :border-bottom "5px #594c7b solid"
           :padding-bottom "5px"
           :margin-bottom "5px"}
      [:.description {:margin-left "20px"
                      :font-size "60%"
                      :color "#ccc"
                      :position "relative"
                      :top "-5px"}]]]]

   [:footer {:text-align "center"
             :padding "10px"
             :background "#101010"
             :color "white"}]

   (at-media {:screen true :max-width "750px"}
             [:header
              [:#title {:margin-bottom "-15px"}
               [:.jumbotronLayer
                [:.jumbotron {:padding-left "10px"
                              :background-size "150%"
                              :color "white"
                              :margin-bottom "-91px"}
                 [:h1 {:margin-top "-20px"
                       :font-size "32px"}]
                 [:p {:margin-top "-10px"
                      :font-size "15px"}]
                 [:.social {:margin-bottom "-5px"}]]]]
              [:.navbar-custom {:border "none"
                                :background-color "rgba(0,0,0,0.5)"}
               [:.navbar-nav
                {:font-size "15px"
                 :margin "0 auto"
                 :display "table"
                 :table-layout "fixed"
                 :float "none"}
                [:li {:transition "background-color 0.3s"}
                 [:&:hover {:background-color "rgba(255,255,255,0.3)"}]]]]])])
