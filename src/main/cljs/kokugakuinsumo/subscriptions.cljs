(ns kokugakuinsumo.subscriptions
  (:require-macros [reagent.ratom :refer [reaction]])
  (:require [reagent.core :as reagent :refer [atom]]
            [re-frame.core :refer [register-sub]]))

(register-sub
  :current-page
  (fn [db _]
    (reaction (:current-page @db))))

(register-sub
  :routes
  (fn [db _]
    (reaction (:routes @db))))

(register-sub
  :links
  (fn [db _]
    (reaction (:links @db))))

(register-sub
  :members
  (fn [db _]
    (reaction (:members @db))))

(register-sub
  :records
  (fn [db _]
    (reaction (:records @db))))

(register-sub
  :schedules
  (fn [db _]
    (reaction (:schedules @db))))
