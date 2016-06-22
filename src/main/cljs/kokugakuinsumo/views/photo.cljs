(ns kokugakuinsumo.views.photo
  (:require [reagent.core :refer [create-class] :as r]
            [kokugakuinsumo.views.components :as c]))

(defn img [photo]
  (let [loaded (r/atom false)]
    (create-class
      {:component-did-mount
       (fn []
         (swap! loaded (fn [] true)))
       :reagent-render
       (fn []
         (let [loaded @loaded]
           [:img {:src (:src photo) :class (str "image"
                                                (when loaded " image-loaded"))}]))})))

(defn photo-page []
  (let [photos [{:src "images/photo/01.jpg" :thumbsrc "images/photo/01.jpg" :caption "photo_01"}
                {:src "images/photo/02.jpg" :thumbsrc "images/photo/02.jpg" :caption "photo_02"}
                {:src "images/photo/03.jpg" :thumbsrc "images/photo/03.jpg" :caption "photo_03"}
                {:src "images/photo/04.jpg" :thumbsrc "images/photo/04.jpg" :caption "photo_04"}
                {:src "images/photo/05.jpg" :thumbsrc "images/photo/05.jpg" :caption "photo_05"}
                {:src "images/photo/06.jpg" :thumbsrc "images/photo/06.jpg" :caption "photo_06"}
                {:src "images/photo/07.jpg" :thumbsrc "images/photo/07.jpg" :caption "photo_07"}
                {:src "images/photo/08.jpg" :thumbsrc "images/photo/08.jpg" :caption "photo_08"}
                {:src "images/photo/09.jpg" :thumbsrc "images/photo/09.jpg" :caption "photo_09"}
                {:src "images/photo/10.jpg" :thumbsrc "images/photo/10.jpg" :caption "photo_10"}
                {:src "images/photo/11.jpg" :thumbsrc "images/photo/11.jpg" :caption "photo_11"}
                {:src "images/photo/12.jpg" :thumbsrc "images/photo/12.jpg" :caption "photo_12"}
                {:src "images/photo/13.jpg" :thumbsrc "images/photo/13.jpg" :caption "photo_13"}
                {:src "images/photo/14.jpg" :thumbsrc "images/photo/14.jpg" :caption "photo_14"}
                {:src "images/photo/15.jpg" :thumbsrc "images/photo/15.jpg" :caption "photo_15"}
                {:src "images/photo/16.jpg" :thumbsrc "images/photo/16.jpg" :caption "photo_16"}
                {:src "images/photo/17.jpg" :thumbsrc "images/photo/17.jpg" :caption "photo_17"}
                {:src "images/photo/18.jpg" :thumbsrc "images/photo/18.jpg" :caption "photo_18"}
                {:src "images/photo/19.jpg" :thumbsrc "images/photo/19.jpg" :caption "photo_19"}
                {:src "images/photo/20.jpg" :thumbsrc "images/photo/20.jpg" :caption "photo_20"}
                {:src "images/photo/21.jpg" :thumbsrc "images/photo/21.jpg" :caption "photo_21"}
                {:src "images/photo/22.jpg" :thumbsrc "images/photo/22.jpg" :caption "photo_22"}
                {:src "images/photo/23.jpg" :thumbsrc "images/photo/23.jpg" :caption "photo_23"}]]
    (create-class
      {:component-will-mount
       (fn [])
       :component-did-mount
       (fn []
         (.lightGallery (js/$ "#lightgallery")))
       :reagent-render
       (fn []
         [:div {:id "photo"}
          [c/row
           [c/col {:xs 12 :md 12}
            [:div {:id "lightgallery"}
             (for [p photos]
               [:a {:href (:src p) :key (:src p)}
                [img p]])
             ]]
           [c/col {:xs 12 :md 12}
            [:a {:href "https://picasaweb.google.com/108652702819533941841?gsessionid=QHR5gVsXYcIgkWL9qh2SgQ"}
             [:p.picasa]]]
           ]])})))
