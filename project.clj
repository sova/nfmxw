(defproject nfmxw "0.0.1"
  :description "low-res version of nonforum with social logins"
  :url "http://www.nonforum.com/"
  :min-lein-version "2.0.0"
  :dependencies [[org.clojure/clojure "1.9.0"]
                 [compojure "1.6.1"]
                 [ring/ring-defaults "0.3.2"]
                 [clj-social "0.1.1"]]
  :plugins [[lein-ring "0.12.4"]]
  :ring {:handler nfmxw.handler/entrypoint}
  :profiles
  {:dev {:dependencies [[javax.servlet/servlet-api "2.5"]
                        [ring/ring-mock "0.3.2"]]}})
