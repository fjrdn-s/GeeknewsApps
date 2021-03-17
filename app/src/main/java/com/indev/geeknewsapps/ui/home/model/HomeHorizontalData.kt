package com.indev.geeknewsapps.ui.home.model

import com.indev.geeknewsapps.R

object HomeHorizontalData {

    private val hrTitle= arrayOf(
            "KODA X Esports",
            "Event Exp 300%",
            "Update Bts"
    )
    private val hrSubTitle= arrayOf(
            "Venture Hadirkan MLBB Online Tournament ...",
            "Kini Hadir Dalam Update Skala Besar A3: Still Alive ...",
            "World Hadirkan Chapter Baru Dengan Tokoh Utama Hoseok ..."
    )
    private val hrDescription= arrayOf(
            "Menapaki bulan ketiga di tahun 2021 ini, Esportsnesia melalui esports venture menghadirkan suasana baru bagi industri esports di Indonesia. Kehadirannya menambah semangat berkompetisi diantara kawula muda yang ingin mengasah kemampuannya di bidang gaming competition yaitu melalui Mobile Legends Online Tournament yang akan diadakan pada tanggal 26-27 Maret 2021.",
            "Netmarble menghadirkan update terbaru untuk Dark Fantasy Open Field MMORPG, A3: STILL ALIVE. Update ini memperkenalkan Region “Somius” yang sebelumnya dapat dilihat di video teaser dan kini telah tersedia untuk dijelajahi serta ditaklukkan oleh para Petualang. Selain itu, beragam event dalam game dan peningkatan lainnya turut hadir untuk para pemain.",
            "hari ini mengumumkan update terbaru untuk BTS WORLD, game simulasi mobile yang menawarkan peran luar biasa sebagai Manager BTS pada para pemain. Update yang tersedia pada hari ini menambahkan Chapter 6 dalam cerita Another Story Season 2 dengan judul “Keajaiban Satu Hari”. Chapter ini menceritakan tentang Hoseok yang menghabiskan satu hari spesial dan berharga bersama peliharaannya, Baekmani."

    )
    private val hrImages= intArrayOf(
            R.drawable.img_1,
            R.drawable.img_2,
            R.drawable.img_3

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
            list.add(homeHrizontal)
        }
        return list
    }
}