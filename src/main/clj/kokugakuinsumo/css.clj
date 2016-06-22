(ns kokugakuinsumo.css
  (:require [garden.def :refer [defstyles]]
            [kokugakuinsumo.styles.about :as about]
            [kokugakuinsumo.styles.app :as app]
            [kokugakuinsumo.styles.linklist :as linklist]
            [kokugakuinsumo.styles.mail :as mail]
            [kokugakuinsumo.styles.member :as member]
            [kokugakuinsumo.styles.photo :as photo]
            [kokugakuinsumo.styles.record :as record]
            [kokugakuinsumo.styles.schedule :as schedule]
            [kokugakuinsumo.styles.top :as top]))

(defstyles screen
  [:body
   {:font-family "\"メイリオ\", Meiryo, Osaka, \"ＭＳ Ｐゴシック\", \"MS PGothic\", Helvetica, Arial, sans-serif"
    :font-size "16px"
    :margin 0
    :height "100%"
    :_overflow "hidden"}
   about/styles
   app/styles
   linklist/styles
   mail/styles
   member/styles
   photo/styles
   record/styles
   schedule/styles
   top/styles])
