(ns nfmxw.handler
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]
            [clj-social.core :refer [make-social]]))

(def logins (atom {:username ""
                   :password ""})) ;one-way hash in production
(def posts (atom {}))
(def threads (atom {}))
(def profiles (atom {}))


(defn spot-page
  "Give spot-page the name of a page section and it will return the relevant HTML."
  ([section] (cond
               (= section :logo) "<div id='logo'>nonforum.com</div>"
               (= section :header) "<link rel='stylesheet' type='text/css' href='nf.css'/>
                                    <div id='vhead'>
                                     <ol>
                                       <li>username</li>
                                       <li>notifications</li>
                                       <li>threads</li>
                                       <li>freshest</li>
                                       <li>trending</li>
                                      </ol>
                                     </div>"
               (= section :body)   "<h2>some body</h2>"
               (= section :footer) "<h7>some footer</h7>"
               (= section :status-bar) "<div id='sss'></div>"
               (= section :login-area) "<form action='/login' method='post'><label>username:<input id='i_n' name='username'/></label><label>password:<input id='i_p' type='password' name='password'/></label><button id='i_s' type='submit'>login</button></form>"
               (= section :create-acc) "<form action='/create-acc' method='post'><label>username:<input id='c_n- name='create_username'/></label><label>password1:<input id='c_p1' type='password' name='p1'/></label><label>password2:<input id='c_p2' type='password' name='p2'/></label><button id='c_s' type='submit'>create</button></form>"
               (= section :js) "<h6>javascript-hear</h6>")))






(defroutes app-routes
  (GET "/" [] "Hello World")
  (GET "/relevant" [] (apply str
                        (spot-page :logo)
                        (spot-page :header)
                        (spot-page :login-area)
                        (spot-page :status-bar)
                        (spot-page :body)
                        (spot-page :footer)
                        (spot-page :create-acc)
                        (spot-page :js)))
  (GET "/footer" [] (spot-page :footer))
  (GET "/statusbar" [] (spot-page :status-bar))
  (POST "/login" [username password] (str username password " to be hashed and stored."))
  (POST "/create-acc" [username p1 p2] (spot-page :logo))
  (route/not-found "Not Found"))

(def entrypoint
  (wrap-defaults app-routes (assoc-in site-defaults [:security :anti-forgery] false)))












;; scope default to nil, state default to UUID
;(def fb (make-social :facebook app-key app-secret callback-uri :state state))

;; get authorization url, then open it to get the callback code
;(def url (.getAuthorizationUrl fb))

;; get access-token
;(def access-token (.getAccessToken fb code))

;; get user info
;(def user (.getUserInfo fb access-token))
