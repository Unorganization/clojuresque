(ns clojuresque.fileio)
(use 'clojure.java.io)


(defn write-to-file
  [file text]
  (with-open [wrtr (writer file)]
    (.write wrtr text)))

(defn read-from-file
  [file]
  (try
    (println (slurp file))
    (catch Exception e (println "Error" (.getMessage e)))))

(defn append-to-file
  [file text]
  (with-open [wrtr (writer file :append true)]
    (.write wrtr text)))

(defn read-lines-from-file
  [file]
  (with-open [rdr (reader file)]
    (doseq [line (line-seq rdr)]
      (println line))))


(defn fileio []
  ,,, (println "file i/o:")

  (write-to-file "mytxt.txt" "hi")
  (append-to-file "mytxt.txt" "hello")
  ,,,(read-lines-from-file "mytxt.txt")
  
  (read-from-file "mytxt.txt"))