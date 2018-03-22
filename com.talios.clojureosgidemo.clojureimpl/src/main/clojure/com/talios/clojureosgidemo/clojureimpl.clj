(ns com.talios.clojureosgidemo.clojureimpl
  (:require [clojure.osgi.services :as os]
            [clojure.tools.logging :as log])
  (:import (com.talios.clojureosgidemo.api EchoService)
           (org.slf4j LoggerFactory)))

(def logger (LoggerFactory/getLogger (name (ns-name *ns*))))

(defn- bundle-start [context]
  "Register OSGi service"
  (.info logger "Starting OSGi from Clojure")  
  (try (os/register-service
         EchoService
         (echo [_ message]
           (.info logger (str "You said " message))
           ;(log/info "tools.logging said something")
           ))
       (catch Exception e
         (.error logger "Unable to register services"))))

(defn- bundle-stop [context]
  (println "bundle-stop is called"))
