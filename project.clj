(defproject kokugakuinsumo/web "1.0.0-SNAPSHOT"
  :dependencies [[org.clojure/clojure "1.9.0-alpha5"]
                 [garden "1.3.2"]
                 [org.clojure/clojurescript "1.9.36"]
                 [reagent "0.6.0-rc" :exclusions [cljsjs/react]]
                 [reagent-utils "0.1.8"]
                 [re-frame "0.7.0"]
                 [secretary "1.2.3"]
                 [venantius/accountant "0.1.7"
                  :exclusions [org.clojure/tools.reader]]

                 [org.clojure/core.async "0.2.374"]
                 [cljsjs/react-with-addons "15.0.2-0"]
                 [cljs-ajax "0.5.4"]
                 [cljsjs/jquery "2.1.4-0"]
                 [cljsjs/jquery-ui "1.11.4-0"]
                 [cljsjs/react-bootstrap "0.29.2-0" :exclusions [org.webjars.bower/jquery]]]
  :min-lein-version "2.5.3"
  :source-paths ["src/main/clj"]
  :plugins [[lein-cljsbuild "1.1.3"]
            [lein-garden "0.2.6"]]
  :clean-targets ^{:protect false} ["resources/public/js/compiled"
                                    "target"
                                    "resources/public/css"]
  :garden {:builds [{:id           "screen"
                     :source-paths ["src/main/clj"]
                     :stylesheet   kokugakuinsumo.css/screen
                     :compiler     {:output-to     "resources/public/css/screen.css"
                                    :pretty-print? true}}]}
  :cljsbuild {:builds
              [{:id           "dev"
                :source-paths ["src/main/cljs"]
                :figwheel     {:on-jsload "kokugakuinsumo.core/main"}
                :compiler     {:main                 kokugakuinsumo.core
                               :output-to            "resources/public/js/compiled/app.js"
                               :output-dir           "resources/public/js/compiled/out"
                               :asset-path           "js/compiled/out"
                               :source-map-timestamp true}}

               {:id           "min"
                :source-paths ["src/main/cljs"]
                :compiler     {:main            kokugakuinsumo.core
                               :output-to       "resources/public/js/compiled/app.js"
                               :optimizations   :advanced
                               :pretty-print    false}}]}

  :profiles {:dev {:plugins [[lein-figwheel "0.5.4-3"]]
                   :figwheel {:css-dirs ["resources/public/css"]}}})
