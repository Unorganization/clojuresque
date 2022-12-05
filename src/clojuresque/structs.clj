(ns clojuresque.structs)

;; According to borkdude, we should use defrecord instead of defstruct
;;
;; Also:
;; defstruct produces clj-kondo warning.  See: https://github.com/clj-kondo/clj-kondo/issues/1894#issuecomment-1334061163
;; So instead of this:
;;    (defstruct Customer :Name :Phone)
;; We do this:
(def Customer (create-struct :Name :Phone))

(def cust1 (struct Customer "Doug" "9495551212"))
(def cust2 (struct-map Customer :Name "Sally" :Phone "5551212"))

(defn struct-map-ex []
  (println cust1)  ; {:Name Doug, :Phone 9495551212}
  (println (:Name cust2))  ; Sally
  )

(defn structs []
  ,,, (println "struct map:")
  (struct-map-ex))