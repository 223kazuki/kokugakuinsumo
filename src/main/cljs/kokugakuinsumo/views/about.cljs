(ns kokugakuinsumo.views.about
  (:require [reagent.core :refer [create-class]]
            [kokugakuinsumo.views.components :as c]
            [cljsjs.react-bootstrap]))

(defn about-page []
  (create-class
    {:component-did-mount
     (fn []
       (.on (js/$ ".card") "inview"
            (fn [event isInView visiblePartX visiblePartY]
              (this-as this
                       (if isInView
                         (.addClass (.stop (js/$ this)) "card-mv")
                         (.removeClass (.stop (js/$ this)) "card-mv"))))))

     :reagent-render
     (fn []
       [:div {:id "about"}
        [c/row
         [c/col {:xs 12 :md 12}
          [:h1 "相撲部について"]]
         [c/col {:xs 12 :md 6 :class "card"}
          [c/thumbnail {:class "thumbnail" :src "/images/about/sumoudoukoukai.png", :alt "國學院大學相撲部"}
           [:h2 "國學院大學相撲同好会"]
           [:p "神道を専攻することの出来る数少ない大学である國學院大學。相撲部はあって当然と思われますが、以前の國學院には相撲部が存在しませんでした。そんな状況を嘆いてか、相撲好きな初代主将が立ち上げたのが当相撲同好会です。"
            [:br]"創部当初は部員不足に悩み、大会でもほとんど勝つことが出来ませんでしたが、地道な活動が実を結び、現在はいくつもの大会で入賞するまでになりました。"
            [:br]]]]
         [c/col {:xs 12 :md 6 :class "card"}
          [c/thumbnail {:class "thumbnail" :src "/images/about/keiko.png", :alt "稽古"}
           [:h2 "稽古"]
           [:p "大相撲をよく見ると言う人でも、相撲の稽古について詳しい人はそう多くはないのではないでしょうか。実際に行ってみると、それぞれの稽古に沢山の意味があることを知って驚くと思います。例えばよく知られている「四股」は神事であることに加え、脚を上げる筋力、柔軟性、バランス感覚等、スポーツで必要なあらゆる要素を含む万能なトレーニングです。"
            [:br]"同好会の稽古では、基礎である四股、すり足、押しから始め、実戦形式の三番、ぶつかりという流れで行います。稽古後には部員で食事に行きます。"]]]
         [c/col {:xs 12 :md 6 :class "card"}
          [c/thumbnail {:class "thumbnail" :src "/images/about/siai.png", :alt "試合"}
           [:h2 "試合"]
           [:p "学生相撲の試合は私たちが参加しているものだけで年に七個も存在します。学生相撲の団体戦は5人制で行われ、先に3勝した側の勝利です。"
            [:br]"個人戦は基本的に体重制ではありませんが、体重別の試合も年に数回行われます。体重別大会は軽～中量級の選手が活躍できる大きな機会です。前主将は75キロ未満級で全国大会出場を果たしました。"
            [:br]"いくつかの試合は両国国技館で開催されるため、参加すると「国技館の土俵に立った」と自慢出来ます。"]]]
         [c/col {:xs 12 :md 6 :class "card"}
          [c/thumbnail {:class "thumbnail" :src "/images/about/tadaigaku.png", :alt "他大学との交流"}
           [:h2 "他大学との交流"]
           [:p "昨年の夏も、三重県の答志島で行われた合同合宿に参加しました。炎天下での稽古と、体を大きくするための食事は大変厳しいものでしたが、それを乗り越えることで大きく成長し、秋の大会での快進撃に繋げることができました。また、合宿中には海水浴、祭、BBQ等のイベントにも参加し、共に稽古した他大学との交流を深めました。"
            [:br]"他大学相撲部とは親密な関係を持ち続けており、名古屋大学、東京大学、立教大学、埼玉大学、日本医科大学、新潟大学、九州大学、豊田通商には出稽古や試合でお世話になっています。"
            [:br]"また、近年は大相撲の部屋の合宿や稽古にも参加するようになりました。大相撲力の方々との交流はとてもよい刺激にもなると共にとても楽しいです。"]]]
         [c/col {:xs 12 :md 6 :class "card"}
          [c/thumbnail {:class "thumbnail" :src "/images/about/nikutai.png", :alt "トレーニング結果"}
           [:h2 "体重"]
           [:p "相撲に対する最も大きな偏見は体型だと思います。「太ってなければ相撲はできない」という偏見です。確かに体重は重要な要素ですが、漫然と太っていれば強いというわけではありません。相撲同好会では現在筋トレに力を入れており、筋肉による増量を目指しています。"
            [:br]"入部当時身長185cmで体重60kgというガリガリな体型だった某部員もトレーニングにより今は90kg近い体重を手にするまでに成長しました。"]]]
         [c/col {:xs 12 :md 6 :class "card"}
          [c/thumbnail {:class "thumbnail" :src "/images/about/media.png", :alt "メディア出演"}
           [:h2 "その他"]
           [:p "相撲同好会は何故かメディア露出が多いです。"
            [:br]"今までに密着ドキュメンタリー、街頭インタビュー、更にはファッション雑誌への出演まで果たしました。NHK総合テレビで放送されていたドキュメンタリー番組「"
            [:a {:href "http://www4.nhk.or.jp/ashitahadocchida/"} "応援ドキュメント 明日はどっちだ"]"」では、川野の入部当初からの成長を軸に國學院相撲同好会が初勝利を挙げるまでの様子が放送されました。撮影時には川野の天然な爆弾発言の数々にひやひやさせられましたが…。"]]]]

        [c/row
         [c/col {:xs 12 :md 12 :class "card"}
          [c/thumbnail {:class "thumbnail"}
           [:h2 "まとめ"]
           [:div "ここまで読んだのであれば、少なからず相撲同好会に興味を持っていただけたと思います。相撲はやっているだけで話題の尽きない競技であり、また競技自体も非常に奥深く、大学生活を捧げるに値する競技です。"
            [:br]"ぜひ一度見学に来て下さい！！"]]
          [:br]]]])}))
