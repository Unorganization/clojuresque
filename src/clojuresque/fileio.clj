(ns clojuresque.fileio
  (:require [clojure.java.io :as io]) ; can use short name 'io'
  )
;; (use 'clojure.java.io) ;; enabling this means you don't need the require java.io, and io/writer is referenced to just writer.  But this gives a clj-kondo warning.


(defn write-to-file
  [file text]
  (with-open [wrtr (io/writer file)]
    (.write wrtr text)))

(defn read-from-file
  [file]
  (try
    (println (slurp file))
    (catch Exception e (println "Error" (.getMessage e)))))

(defn append-to-file
  [file text]
  (with-open [wrtr (io/writer file :append true)]
    (.write wrtr text)))

(defn read-lines-from-file
  [file]
  (with-open [rdr (io/reader file)]
    (doseq [line (line-seq rdr)]
      (println line))))


(defn fileio []
  ,,, (println "file i/o:")

  (write-to-file "mytxt.txt" "hi")
  (append-to-file "mytxt.txt" "hello")
  ,,,(read-lines-from-file "mytxt.txt")
  
  (read-from-file "mytxt.txt"))