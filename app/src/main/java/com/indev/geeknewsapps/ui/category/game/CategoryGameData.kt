package com.indev.geeknewsapps.ui.category.game

import com.indev.geeknewsapps.ui._model.ModelData

object CategoryGameData {

    private val hrTitle = arrayOf(
            "Gravity Game Link Umumkan 4 Game Terbaru Sekaligus Di Acara Gravity Day 2021",
            "Update Terbaru Lineage2 Revolution Membuka Batas Wilayah Rune Baru",
            "Elisabeth Dari The King Of Fighters Xi Hadir Dalam Update The King Of Fighters Allstar Di Tahun 2021",
            "Kingdoms : Iron and Blood Akan Dirilis 27 Januari 2021",
            "Game Fantasi Golf “Birdie Crush” Mencapai 1 Juta Pra-Registrasi"
    )

    private val hrYt = arrayOf(
            "",
            "CZqX46AjHa0",
            "WN2Bv5U-Eww",
            "LznWwg4ta10",
            "Fw1WFOIj0aQ"
    )

    private val hrDescription = arrayOf(
            "Geeknews.id —  Di tahun 2021 yang sangat istimewa ini Gravity Game Link kembali menyelenggarakan event tahunannya yang diberi nama Gravity Day 2021 secara daring pada tanggal 12 Maret 2021 melalui Platform Zoom, Pada acara Gravity Day 2021, Gravity Game Link secara resmi mengumumkan informasi penting terkait dengan Project Plan & Business Plan khususnya pangsa pasar Indonesia di tahun 2021. Gravity Game Link berkomitmen untuk terus melakukan upaya terbaiknya dalam meningkatkan pertumbuhan industri game di Indonesia, upaya tersebut diwujudkan dengan menghadirkan beberapa game terbaru dari Gravity Game Link di tahun 2021.",

            "Geeknews.id – Update terbaru MMORPG mobile populer, Lineage2 Revolution, menghadirkan wilayah baru untuk dijelajahi dan ditaklukkan, bersama dengan beberapa tambahan baru lainnya yang kini telah tersedia untuk dinikmati oleh para pemain, mulai hari ini, wilayah Rune telah tersedia untuk dijelajahi dan terbagi menjadi 2 area, yaitu Silent Provenance dan Ravine of Frenzy. Level maksimum untuk pemain juga telah ditingkatkan dari Lv. 480 menjadi Lv. 520 dan dua Elite Dungeon akan dimasukkan ke dalam wilayah baru ini.",

            "Geeknews.id – Controller of the White Light, Elisabeth Blanctorche, hadir untuk pertama kalinya dalam update terbaru game action mobile RPG populer, THE KING OF FIGHTERS ALLSTAR. Update ini memperkenalkan Fighter terkenal dari THE KING OF FIGHTERS XI kepada para pemain yang ingin menambahkan karakter ini ke dalam daftar koleksi mereka.",

            "Geeknews.id – LYTO mengumumkan tanggal perilisan Kingdoms : Iron and Blood, game strategy mobile terbaru yaitu pada tanggal 27 Januari 2021, Jumat lalu. Jadilah Panglima terhebat, ubah sejarah Three Kingdoms dan taklukkan semua musuhmu dalam upaya untuk menjadi Panglima legendaris, Pada Kingdoms : Iron and Blood, Pemain akan bermain sebagai seorang Panglima yang ikut terlibat dalam berbagai kejadian selama era Three Kingdoms. Beberapa diantaranya termasuk Pemberontakan Yellow Turban, Pertempuran Gerbang Hu Lao, sampai Pertempuran Chibi, atau, kamu bisa membuat sejarahmu sendiri di kota-kota lainnya dengan menguasai kota tersebut dan bertahan dari serangan musuh.",

            "Geeknews.id – Perusahaan game mobile Com2uS (CEO James Song) pada tanggal 26 Januari ini telah mengumumkan kalau game Fantasi Golf mereka, Birdie Crush, telah mencapai 1 juta pra-registrasi. Game ini juga dijadwalkan untuk diluncurkan secara global 4 Februari mendatang, Birdie Crush sebelumnya telah diluncurkan di Indonesia bulan Agustus 2019. Banyak gamer Indonesia telah merasakan keasikan bermain golf fantasi ini sebelum user global lainnya. Kini game ini sudah siap diluncurkan dan bisa dinikmati oleh gamer seluruh dunia."

    )
    private val hrImages = arrayOf(
            "https://geeknews.id/wp-content/uploads/2021/03/ragnarok-origin.jpg",
            "https://geeknews.id/wp-content/uploads/2021/02/Lineage2-Revolution-Update-Terbaru-Membuka-Batas-Wilayah-Rune-Baru-yang-Membuat-Petualangan-Semakin-Menyenangkan-e1614066424640.jpg",
            "https://geeknews.id/wp-content/uploads/2021/02/THE-KING-OF-FIGHTERS-ALLSTAR-Elisabeth-dari-The-King-Of-Fighters-Xi-Hadir-dalam-Update-Pertama-di-Tahun-2021-e1612175921498.jpg",
            "https://geeknews.id/wp-content/uploads/2021/02/Image-1-e1612173877600.jpg",
            "https://geeknews.id/wp-content/uploads/2021/02/PR-Cover-e1612172143346.jpg"

    )

    private val hrCategory = arrayOf(
            "GAME",
            "GAME",
            "GAME",
            "GAME",
            "GAME"
    )

    private val hrPostTime = arrayOf(
            "2 week ago",
            "1 hour ago",
            "1 mount ago",
            "1 week ago",
            "5 hour ago"
    )

    private val hrPostBy = arrayOf(
            "By Geeknews Indonesia",
            "By Riyan Agustiar Sutardi",
            "By Geeknews Indonesia",
            "By Riyan Agustiar Sutardi",
            "By Geeknews Indonesia"
    )

    val listData: ArrayList<ModelData>
        get() {
            val list = arrayListOf<ModelData>()
            for (position in hrTitle.indices) {
                val modelData = ModelData()
                modelData.title = hrTitle[position]
                modelData.description = hrDescription[position]
                modelData.imagesUrl = hrImages[position]
                modelData.category = hrCategory[position]
                modelData.postTime = hrPostTime[position]
                modelData.postBy = hrPostBy[position]
                modelData.youtubeUrl = hrYt[position]
                list.add(modelData)
            }
            return list
        }
}