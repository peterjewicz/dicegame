(ns dicegame.core
  (:gen-class))

(defn next-roll
  "Generates a random number 0-6"
  []
  (rand-int 6))


(defn -main
  "Dice game"
  [& args]

  (def running-total (atom 0))
  (dotimes [n 100]
    (reset! running-total (- @running-total 10))
    (loop [roll 0]

      (if (and (< roll 14) (> roll 10))
        (reset! running-total (+ @running-total roll)))
      (println @running-total)
      (if (< roll 11)
        (recur (+ (next-roll) roll)))
    )
  )
    (println @running-total)
)
