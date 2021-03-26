package com.indev.geeknewsapps.ui.category.event

import com.indev.geeknewsapps.ui._model.ModelData

object CategoryEventData {

    private val hrTitle= arrayOf(
            "KODA X Esports Venture Hadirkan MLBB",
            "Event Exp 300% Dalam Update Skala Besar",
            "Overwatch – Kanezaka Challenge Telah Hadir",
            "EVOS Esports Tandatangani Juara Dunia PUBG",
            "Sambut Event Natal Di Blade&Soul Revolution MMORPG"
    )

    private val hrDescription= arrayOf(
            "Geeknews.id – Menapaki bulan ketiga di tahun 2021 ini, Esportsnesia melalui esports venture menghadirkan suasana baru bagi industri esports di Indonesia. Kehadirannya menambah semangat berkompetisi diantara kawula muda yang ingin mengasah kemampuannya di bidang gaming competition yaitu melalui Mobile Legends Online Tournament yang akan diadakan pada tanggal 26-27 Maret 2021.",

            "Geeknews.id – Netmarble menghadirkan update terbaru untuk Dark Fantasy Open Field MMORPG, A3: STILL ALIVE. Update ini memperkenalkan Region “Somius” yang sebelumnya dapat dilihat di video teaser dan kini telah tersedia untuk dijelajahi serta ditaklukkan oleh para Petualang. Selain itu, beragam event dalam game dan peningkatan lainnya turut hadir untuk para pemain.",

            "Geeknews.id – Kobarkan jiwa ksatriamu– kini di tahun baru dengan free-for-all Deatmatch map terbaru Kanezaka sudah bisa dinikmati di PC, PlayStation, Xbox dan Nintendo Switch! Mulai hari ini hingga 25 Januari, pemain bisa mendapatkan hadiah terbatas, termasuk enam spray unik dan satu epic Skin Kyogisha Hanzo dengan total tujuh hadiah. Tonton langsung trailer Kanezaka Challenge. Untuk informasi selengkapnya, kunjungi event site dan blog post nya.",

            "Geeknews.id – EVOS Esports, organisasi esports terkemuka di Asia Tenggara, telah mengumumkan penandatanganan juara dunia Nizar “Microboy” Lugatio Pratama, atlet esports profesional PUBG Mobile.",

            "Geeknews.id – Perusahaan game global, Netmarble Corp, hari ini mengumumkan hadirnya update terbaru untuk Blade&Soul Revolution, mobile MMORPG aksi oriental yang menampilkan cerita sinematik memukau tentang pembalasan dendam dari adaptasi game PC online Blade&Soul. Update ini memperkenalkan Skill Badge baru serta beragam event untuk merayakan liburan akhir tahun dan tahun baru."

    )
    private val hrImages= arrayOf(
            "https://geeknews.id/wp-content/uploads/2021/03/KODA-X-Esports-Venture-e1615558071544.jpg",
            "https://geeknews.id/wp-content/uploads/2021/02/A3_STILL-ALIVE-Event-EXP-300-dan-Region-Baru-Somius-Kini-Hadir-Dalam-Update-Skala-Besar-e1614067675552.jpg",
            "https://geeknews.id/wp-content/uploads/2021/01/Overwatch-Kanezaka-Challenge-Telah-Hadir-e1610537634128.jpg",
            "https://geeknews.id/wp-content/uploads/2021/02/EVOS-Microboy-min-scaled-e1612176358574.jpg",
            "https://geeknews.id/wp-content/uploads/2020/12/BladeSoul-Revolution-Sambut-Tahun-Baru-dengan-Event-Perayaan-Liburan-e1609313942537.jpg"

    )

    private val hrCategory= arrayOf(
            "EVENT",
            "EVENT",
            "EVENT",
            "EVENT",
            "EVENT"
    )

    private val hrPostTime= arrayOf(
            "2 week ago",
            "1 hour ago",
            "1 mount ago",
            "1 week ago",
            "5 hour ago"
    )

    private val hrPostBy= arrayOf(
            "By Geeknews Indonesia",
            "By Riyan Agustiar Sutardi",
            "By Geeknews Indonesia",
            "By Riyan Agustiar Sutardi",
            "By Riyan Agustiar Sutardi"
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
                list.add(modelData)
            }
            return list
        }
}