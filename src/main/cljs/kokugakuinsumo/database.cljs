(ns kokugakuinsumo.database
  (:require [kokugakuinsumo.views.top :refer [top-page]]
            [kokugakuinsumo.views.about :refer [about-page]]
            [kokugakuinsumo.views.linklist :refer [linklist-page]]
            [kokugakuinsumo.views.mail :refer [mail-page]]
            [kokugakuinsumo.views.member :refer [member-page]]
            [kokugakuinsumo.views.photo :refer [photo-page]]
            [kokugakuinsumo.views.record :refer [record-page]]
            [kokugakuinsumo.views.schedule :refer [schedule-page]]))

(defn no-page []
  [:div])

(def initial-state
  {:routes  {:top-page  #'top-page
             :about-page #'about-page
             :linklist-page #'linklist-page
             :mail-page #'mail-page
             :member-page #'member-page
             :photo-page #'photo-page
             :record-page #'record-page
             :schedule-page #'schedule-page
             :no-page    #'no-page}

   :current-page :no-page})
