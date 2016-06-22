(ns kokugakuinsumo.styles.member)

(def styles
  [:#member
   [:#memberHeader {:width "100%"
                    :text-align "left"
                    :margin-bottom "10px"}
    [:thead [:tr {:background-color "black"
                  :color "white"}
             [:th {:padding-top "2px"
                   :padding-left "5px"}]
             [:td {:padding-top "2px"
                   :padding-left "5px"}]]]
    [:tbody
     [:tr {:transition "background-color color 0.1s"}
      [:&:hover {:color "red"}]
      [(keyword "&:nth-child(2n)") {:background-color "white"}]
      [(keyword "&:nth-child(2n+1)") {:background-color "#e0e0e0"}]
      [:&:hover {:background-color "#d6a8ff"
                 :cursor "pointer"}]]]]

   [:#memberBody
    [:.caption
     [:h3 {:width "100%"
           :text-align "center"
           :border-bottom "5px #594c7b solid"
           :padding-bottom "0px"
           :margin-bottom "10px"}
      [:span.yomi {:margin-left "10px"
                   :font-size "50%"
                   :color "#ccc"
                   :position "relative"
                   :top "0px"}]]
     [:h4 {:font-size "15px"
           :font-weight "bold"
           :margin-bottom "5px"}]
     [:p.toTop {:width "100%"
                :margin-top "10px"
                :text-align "right"
                :text-decoration "none"
                :vertical-align "bottom"
                :font-weight "bold"
                :transition "color 0.1s"}
      [:&:hover{:color "red"
                :cursor "pointer"}]]]]])
