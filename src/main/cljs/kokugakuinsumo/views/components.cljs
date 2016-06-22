(ns kokugakuinsumo.views.components
  (:require [reagent.core :refer [adapt-react-class]]
            [cljsjs.react-bootstrap]))

(def button (adapt-react-class (aget js/ReactBootstrap "Button")))
(def css-transition-group (adapt-react-class js/React.addons.CSSTransitionGroup))
(def nav (adapt-react-class (aget js/ReactBootstrap "Nav")))
(def row (adapt-react-class (aget js/ReactBootstrap "Row")))
(def col (adapt-react-class (aget js/ReactBootstrap "Col")))
(def jumbotron (adapt-react-class (aget js/ReactBootstrap "Jumbotron")))
(def thumbnail (adapt-react-class (aget js/ReactBootstrap "Thumbnail")))
(def tabs (adapt-react-class (aget js/ReactBootstrap "Tabs")))
(def tab (adapt-react-class (aget js/ReactBootstrap "Tab")))
