(ns kokugakuinsumo.styles.top)

(def styles
  [:#top
   [:img {:margin-bottom "10px"}]
   [:table {:width "100%"}
    [:thead {:background-color "black"}
     [:tr {:color "white"}
      [:th {:padding "3px"
            :padding-left "5px"}]]]
    [:tbody
     [(keyword "tr:nth-child(2n)") {:background-color "white"}]
     [(keyword "tr:nth-child(2n+1)") {:background-color "#e0e0e0"}]
     [:td {:padding "3px"
           :padding-left "5px"}]
     [:th {:padding "3px"
           :padding-left "5px"}]]]
   [:h3 {:font-size "20px"}]
   [:ul
    [:li {:font-size "16px"}
     [:p {:margin-top "3px"
          :margin-bottom "3px"
          :margin-left "10px"
          :font-size "13px"
          :color "gray"}]]]])
