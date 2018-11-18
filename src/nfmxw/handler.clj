(ns nfmxw.handler
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]
            [clj-social.core :refer [make-social]]))



(defn spot-page
  "Give spot-page the name of a page section and it will return the relevant HTML."
  ([section] (= section :header) "<html>some header </html>"))





(defroutes app-routes
  (GET "/" [] "Hello World")
  (route/not-found "Not Found"))

(def app
  (wrap-defaults app-routes site-defaults))












;; scope default to nil, state default to UUID
;(def fb (make-social :facebook app-key app-secret callback-uri :state state))

;; get authorization url, then open it to get the callback code
;(def url (.getAuthorizationUrl fb))

;; get access-token
;(def access-token (.getAccessToken fb code))

;; get user info
;(def user (.getUserInfo fb access-token))
