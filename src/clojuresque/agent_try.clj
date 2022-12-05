(ns clojuresque.agent-try)

(def tickets-sold (agent 0))

(defn agent-ex []
  ,,, (println "agents:")

  (send tickets-sold + 15)
  (await-for 100 tickets-sold)
  (println "Tickets: " @tickets-sold)

  (send tickets-sold + 10)
  (await-for 100 tickets-sold)
  (println "Tickets: " @tickets-sold)

  (shutdown-agents))
