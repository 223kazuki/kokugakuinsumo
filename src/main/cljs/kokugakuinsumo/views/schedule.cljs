(ns kokugakuinsumo.views.schedule)

(defn schedule-page []
  [:div {:id "schedule"}
   [:row
    [:h1 "年間スケジュール"]
    [:h2 "6月"]
    [:h3 "東日本学生相撲選手権大会"]
    [:div "シーズン初めの大会で、東日本の大学による団体・個人のトーナメントを行います。\n              毎年両国国技館で行われるため、必ず国技館の土俵に立てます。"
     [:p
      [:a {:href "http://ameblo.jp/kokugakuin-sumo/entry-11875474610.html", :target "_blank"} "東日本学生相撲選手権大会"]]]
    [:h2 "7月"]
    [:h3 "香港上海オープン相撲大会"]
    [:div "毎年江東区で開催される、誰でも参加できる相撲大会です。"
     [:p
      [:a {:href "http://ameblo.jp/kokugakuin-sumo/entry-11574066518.html?frm_src=thumb_module", :target "_blank"} "第14回 香港上海倶楽部オープン"]]]
    [:h2 "8月"]
    [:h3 "答志島合宿"]
    [:div "三重県鳥羽市の答志島で行われる大学相撲部の合同合宿です。\n              主催校の名古屋大学の他、大阪大学、関西大学、京都大学、新潟大学、九州大学、豊田通商相撲部等が参加しています。\n              炎天下で行われる稽古はとても辛いですが、毎食の海の幸や、稽古後の海水浴や、地元の盆踊り等、楽しみの多い合宿です。"
     [:p
      [:a {:href "http://ameblo.jp/kokugakuin-sumo/entry-11593611496.html", :target "_blank"} "答志島合宿"]]]
    [:h3 "東日本学生相撲個人体重別選手権大会"]
    [:div "東日本の大学によって行われる体重別の大会です。階級は下から65kg未満、75kg未満、86kg未満、100kg未満、115kg未満、135kg未満、135kg以上、無差別級です。\n              ベスト8からの決勝トーナメントに進出すると、全国体重別大会への出場権を獲得できます。"
     [:p
      [:a {:href "http://ameblo.jp/kokugakuin-sumo/entry-11605528568.html", :target "_blank"} "東日本学生相撲個人体重別選手権大会"]]]
    [:h2 "9月"]
    [:h3 "東日本学生相撲リーグ戦"]
    [:div "東日本の大学で行われるリーグ戦形式で行われる試合です。一年で最も多くの大学と戦うことの出来る試合です。"
     [:p
      [:a {:href "http://ameblo.jp/kokugakuin-sumo/entry-11615627456.html", :target "_blank"} "東日本学生相撲リーグ戦"]]]
    [:h3 "全国学生相撲個人体重別選手権大会"]
    [:div "東日本体重別で決勝トーナメントに残った場合に出場出来る体重別の全国大会です。この大会で優勝すれば全国チャンピオンを名乗ることが出来ます。"
     [:p
      [:a {:href "http://ameblo.jp/kokugakuin-sumo/entry-11620636937.html", :target "_blank"} "全国学生相撲個人体重別選手権大会"]]]
    [:h2 "11月"]
    [:h3 "全国学生相撲選手権大会"]
    [:div "学生相撲のインカレです。この試合が一年の最大の目標であり、西日本の大学と団体戦で対戦できる唯一の機会です。"
     [:p
      [:a {:href "http://ameblo.jp/kokugakuin-sumo/entry-11950725172.html", :target "_blank"} "第92回全国学生相撲選手権大会"]]]
    [:h2 "その他"]
    [:h3 "代官山 春花祭"]
    [:div "國學院大學の一員として、國學院が運営に関わるイベントの手伝いに参加したりなどもします。"
     [:p
      [:a {:href "http://ameblo.jp/kokugakuin-sumo/entry-11841818533.html", :target "_blank"} "代官山 春花祭"]]]]])
