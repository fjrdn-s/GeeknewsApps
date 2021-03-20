package com.indev.geeknewsapps.ui.home._model

import com.indev.geeknewsapps.R

object HomeHorizontalData {

    private val hrTitle= arrayOf(
            "KODA X Esports",
            "Event Exp 300%",
            "Update Bts",
            "Laptop Gaming 15 inci",
            "Ragnaro Origin"
    )
    private val hrSubTitle= arrayOf(
            "Venture Hadirkan MLBB Online Tournament ...",
            "Kini Hadir Dalam Update Skala Besar A3: Still Alive ...",
            "World Hadirkan Chapter Baru Dengan Tokoh Utama Hoseok ...",
            "Nikmati Immersive Gameplay dengan GeForce RTX™ ...",
            "Gravity Game Link Umumkan 4 Game Terbaru Sekaligus Di Acara Gravity Day 2021 ..."
    )
    private val hrDescription= arrayOf(
            "Menapaki bulan ketiga di tahun 2021 ini, Esportsnesia melalui esports venture menghadirkan suasana baru bagi industri esports di Indonesia. Kehadirannya menambah semangat berkompetisi diantara kawula muda yang ingin mengasah kemampuannya di bidang gaming competition yaitu melalui Mobile Legends Online Tournament yang akan diadakan pada tanggal 26-27 Maret 2021.",
            "Netmarble menghadirkan update terbaru untuk Dark Fantasy Open Field MMORPG, A3: STILL ALIVE. Update ini memperkenalkan Region “Somius” yang sebelumnya dapat dilihat di video teaser dan kini telah tersedia untuk dijelajahi serta ditaklukkan oleh para Petualang. Selain itu, beragam event dalam game dan peningkatan lainnya turut hadir untuk para pemain.",
            "hari ini mengumumkan update terbaru untuk BTS WORLD, game simulasi mobile yang menawarkan peran luar biasa sebagai Manager BTS pada para pemain. Update yang tersedia pada hari ini menambahkan Chapter 6 dalam cerita Another Story Season 2 dengan judul “Keajaiban Satu Hari”. Chapter ini menceritakan tentang Hoseok yang menghabiskan satu hari spesial dan berharga bersama peliharaannya, Baekmani.",
            "Lenovo Indonesia meluncurkan Legion Slim 7i berukuran 15 inci yang merupakan produk gaming Lenovo terbaru yang hadir di Indonesia di tahun 2021. Legion Slim 7i mendorong batas portabilitas dan performa sehingga para pengguna dapat meningkatkan level game di mana pun. Ditenagai oleh sampai dengan prosesor 8 core Intel® Core™ i7-10870H Series Generasi ke-10 dan grafis NVIDIA® GeForce® RTX.",
            "Di tahun 2021 yang sangat istimewa ini Gravity Game Link kembali menyelenggarakan event tahunannya yang diberi nama Gravity Day 2021 secara daring pada tanggal 12 Maret 2021 melalui Platform Zoom, Pada acara Gravity Day 2021, Gravity Game Link secara resmi mengumumkan informasi penting terkait dengan Project Plan & Business Plan khususnya pangsa pasar Indonesia di tahun 2021."

    )
    private val hrImages= intArrayOf(
            R.drawable.img_1,
            R.drawable.img_2,
            R.drawable.img_3,
            R.drawable.img_4,
            R.drawable.img_5

    )

    private val hrCategory= arrayOf(
            "GAME",
            "EVENT",
            "MOVIE",
            "TECH",
            "GAME"
    )

    private val hrPostTime= arrayOf(
            "2 week ago",
            "1 hour ago",
            "3 mount ago",
            "1 week ago",
            "4 hour ago"
    )

    val listData: ArrayList<HomeHorizontal>
    get() {
        val list= arrayListOf<HomeHorizontal>()
        for (position in hrTitle.indices) {
            val homeHrizontal= HomeHorizontal()
            homeHrizontal.title= hrTitle[position]
            homeHrizontal.subTitle= hrSubTitle[position]
            homeHrizontal.description= hrDescription[position]
            homeHrizontal.images= hrImages[position]
            homeHrizontal.category= hrCategory[position]
            homeHrizontal.postTime= hrPostTime[position]
            list.add(homeHrizontal)
        }
        return list
    }
}