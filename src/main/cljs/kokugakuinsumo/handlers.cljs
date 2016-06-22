(ns kokugakuinsumo.handlers
  (:require-macros [reagent.ratom :refer [reaction]])
  (:require [reagent.core :as reagent :refer [atom]]
            [re-frame.core :as r :refer [register-handler]]
            [ajax.core :as ajax]
            [cljs.core.async :as async :refer [<! timeout]]
            [kokugakuinsumo.database :refer [initial-state]]))

(register-handler
  :initialize
  (fn
    [db _]
    (merge db initial-state)))

(register-handler
  :set-current-page
  (fn
    [db [_ page]]
    (assoc db :current-page page)))

;; 部員
(r/register-handler
  :get-members-success
  (fn
    [db [_ response]]
    (assoc db
      :members response
      :loading? false)))

(r/register-handler
  :get-members-failure
  (fn
    [db [_ e]]
    (when (== (:status e) 401)
      (set! (.-location js/window) "/"))
    (println e)
    (assoc db :loading? false)))

(r/register-handler
  :get-members
  (fn [db [_ _]]
    (ajax/GET (str "/data/members.json")
              {:handler (fn [res] (r/dispatch [:get-members-success res]))
               :error-handler (fn [e] (r/dispatch [:get-members-failure e]))
               :response-format :json
               :keywords? true
               :timeout 10000})
    (assoc db :loading? true)))

;; 戦績
(r/register-handler
  :get-records-success
  (fn
    [db [_ response]]
    (assoc db
      :records response
      :loading? false)))

(r/register-handler
  :get-records-failure
  (fn
    [db [_ e]]
    (when (== (:status e) 401)
      (set! (.-location js/window) "/"))
    (println e)
    (assoc db :loading? false)))

(r/register-handler
  :get-records
  (fn [db [_ _]]
    (ajax/GET (str "/data/records.json")
              {:handler (fn [res] (r/dispatch [:get-records-success res]))
               :error-handler (fn [e] (r/dispatch [:get-records-failure e]))
               :response-format :json
               :keywords? true
               :timeout 10000})
    (assoc db :loading? true)))

;; 予定
(r/register-handler
  :get-schedules-success
  (fn
    [db [_ response]]
    (assoc db
      :schedules response
      :loading? false)))

(r/register-handler
  :get-schedules-failure
  (fn
    [db [_ e]]
    (when (== (:status e) 401)
      (set! (.-location js/window) "/"))
    (println e)
    (assoc db :loading? false)))

(r/register-handler
  :get-schedules
  (fn [db [_ _]]
    (ajax/GET (str "/data/schedules.json")
              {:handler (fn [res] (r/dispatch [:get-schedules-success res]))
               :error-handler (fn [e] (r/dispatch [:get-schedules-failure e]))
               :response-format :json
               :keywords? true
               :timeout 10000})
    (assoc db :loading? true)))

;; リンク
(r/register-handler
  :get-links-success
  (fn
    [db [_ response]]
    (assoc db
      :links response
      :loading? false)))

(r/register-handler
  :get-links-failure
  (fn
    [db [_ e]]
    (when (== (:status e) 401)
      (set! (.-location js/window) "/"))
    (println e)
    (assoc db :loading? false)))

(r/register-handler
  :get-links
  (fn [db [_ _]]
    (ajax/GET (str "/data/links.json")
              {:handler (fn [res] (r/dispatch [:get-links-success res]))
               :error-handler (fn [e] (r/dispatch [:get-links-failure e]))
               :response-format :json
               :keywords? true
               :timeout 10000})
    (assoc db :loading? true)))
