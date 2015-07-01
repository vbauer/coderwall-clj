(ns ^{:author "Vladislav Bauer"}
  coderwall-clj.client
  (:require [clj-http.client :as http]))


(def ^:dynamic DEF_API_URL "https://coderwall.com/")
(def ^:dynamic DEF_FORMAT ".json")
(def ^:dynamic DEF_HTTP_CONFIG
  {:as :json
   :accept :json
   :insecure? true
   :throw-exceptions true
   :socket-timeout 10000
   :conn-timeout 10000})


(defn user-url [user-name]
  (str DEF_API_URL (name user-name) DEF_FORMAT))

(defn user-data
  ([user-name]
   (user-data user-name true))
  ([user-name full?]
   (user-data user-name full? DEF_HTTP_CONFIG))
  ([user-name full? http-config]
   (let [url (user-url user-name)
         query-params {:query-params {:full full?}}
         config (merge http-config query-params)
         response (http/get url config)]
     (:body response))))
