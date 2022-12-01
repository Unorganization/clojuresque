(ns clojuresque.protocols)

(defprotocol Display
  (title [this])
  (description [this description]))

(defrecord Person [name phone]
  Display
  (title [this] (str "This is " name " with phone " phone))
  (description [this descr] (str name " with phone " phone " is " descr)))

(def bob (->Person "Bob" "555-1212"))

(defrecord Product [name price])
(def toaster (->Product "Toaster" 19.95))

(defn protocols []
  ,,, (println "protocols")
  (println (:name bob))  ; Bob
  (println (:phone bob))  ; 555-1212
  (println (title bob))  ; This is Bob with phone 555-1212
  (println (description bob "a man"))  ; Bob with phone 555-1212 is a man

; extend an pre-existing Record type with an protocol
  (extend-protocol Display
    Product
    (title [p] (str "This product is a " (:name p)))
    (description [p desc] (str "The " (:name p) " costs " (:price p) " and " desc)))
  (println (title toaster))  ; This product is a Toaster
  (println (description toaster "not on sale"))  ; The Toaster costs 19.95 and not on sale
  )
