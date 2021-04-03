package com.indev.geeknewsapps.ui.category.movie

import com.indev.geeknewsapps.ui._model.ModelData

object CategoryMovieData {

    private val hrTitle = arrayOf(
            "The LEGO Movie 2: The Second Part – Petualangan Emmet Kembali Lagi!",
            "Attack on Titan Trending Terus. Ini 7 Karakter Keren",
            "Film Marvel ini Menjadi Inspirasi Film Fast and Furious 9",
            "6 Soundtrack Drakor Mr. Queen Ini Hits Banget",
            "Bintang The Penthouse, Kim Young Dae akan Tampil di True Beauty"
    )

    private val hrYt = arrayOf(
            "11K013qpRR4",
            "M_OauHnAFc8",
            "Kopyc23VfSw",
            "z5CfInEukJk",
            "yhB4ZnFmc8o"
    )

    private val hrDescription = arrayOf(
            "Geeknews.id – Film tentang mainan LEGO yang menjadi karakter hidup di 2014 lalu kini kembali lagi. Melalui The LEGO Movie 2: The Second Part, Phil Lord dan Chris Miller mencoba kembali membangun imajinasi penonton dari film yang sukses besar pada 5 tahun silam itu.\n" +
                    "\n" +
                    "The LEGO Movie pernah hadir dalam bentuk spin-off pada 2017 melalui The LEGO Batman Movie dan The LEGO Ninjago Movie. Tapi sepertinya dua film itu tidak sesukses film pertamanya. Oleh sebab itulah sekuel dari film ini sekarang dimunculkan. Dan inilah sinopsis The LEGO Movie 2: The Second Part.",

            "Geeknews.id – Attack on Titan episode 7 sempat menjadi trending karena kemunculan tokoh Armin yang baru muncul lagi kali ini. Perubahan Armin menjadi Titan membuat banyak netizen bersorak. Perang besar yang melibatkan pihak Paradis dan Marley pun meledak. Siapakah Armin?\n" +
                    "\n" +
                    "Tayang di Viu setiap Senin, Attack on Titan memiliki sejumlah karakter yang membuat para pecinta anime jatuh cinta. Mereka menyimpan trauma dan dendam, berlatih mati-matian dan bertarung sampai titik darah penghabisan.",

            "Geeknews.id — Vin Diesel akan muncul kembali dalam film Fast and Furious 9 yang tayang tahun 2021. Franchise Fast and Furious sendiri akan berakhir dengan film ke-10 dan 11.\n" +
                    "\n" +
                    "Ternyata, konsep mengakhiri franchise Fast and Furious menjadi 2 film ini terinspirasi dari Infinity Saga produksi Marvel Studios. Marvel memecah akhir cerita menjadi Avengers: Infinity War dan Avengers Endgame.\n" +
                    "\n" +
                    "Vin Diesel dalam wawancara promosi Fast and Furious 9 bersama Entertainment Weekly menjelaskan, apa rencana awal Fast and Furious dan bagaimana akhir franchise itu terinspirasi dari film Marvel.",

            "Geeknews.id – Akhir pekan ini, Mr. Queen akan memasuki episode 14 dengan misteri yang semakin bikin penasaran. Akankah nasib Raja Cheoljong semakin tragis setelah kehilangan beberapa orang kepercayaannya? Benarkah ada sekelompok orang yang akan membunuh sang ratu?\n" +
                    "\n" +
                    "Kisah jiwa seorang koki dari dunia modern yang terjebak dalam tubuh ratu dari dinasti Joseon ini selalu dinanti oleh jutaan pecinta drama Korea dari seluruh dunia. Anda dapat menyaksikannya setiap Minggu dan Senin secara eksklusif di Viu.\n" +
                    "\n" +
                    "Namun tak hanya ceritanya, Mr Queen juga didukung para penyanyi dan penulis lagu hebat yang menghasilkan soundtrack keren. Hasilnya adalah enam soundtrack berikut yang akan membuat angan Anda melambung untuk menyelami perasaan sang ratu dan tokoh lain dalam drama ini.",

            "Geeknews.id – Setelah memukau dalam drama Korea The Penthouse yang sangat digemari oleh pecinta drakor di penjuru dunia, Kim Young Dae akan segera tampil dalam True Beauty.\n" +
                    "\n" +
                    "True Beauty hari ini telah memasuki episode 12 dan Lim Ju Kyung (Moon Ga Young) memasuki masa-masa kritis karena seluruh sekolah telah mengetahui wajah asli tanpa riasan. Hal ini juga mengingatkannya tentang masa-masa berat di sekolah dulu sebagai korban bully. Seperti apa peran Kim Young Dae saat Lim Ju Kyung menghadapi periode berat ini? Anda dapat menemukannya dalam True Beauty yang tayang setiap Kamis dan Jumat, eksklusif di Viu."

    )
    private val hrImages = arrayOf(
            "https://geeknews.id/wp-content/uploads/2019/02/sinopsis-The-LEGO-Movie-2-The-Second-Part-4.jpg",
            "https://geeknews.id/wp-content/uploads/2021/01/AOT_S4_16x9_WT-e1610360069731.jpg",
            "https://geeknews.id/wp-content/uploads/2021/01/fast-3-1536x864.jpg",
            "https://geeknews.id/wp-content/uploads/2020/12/MR.-QUEEN-28-1-scaled-e1609314754483.jpg",
            "https://geeknews.id/wp-content/uploads/2021/01/Kim-Young-Dae-Cheat-on-Me-If-You-Can-Character-Poster-3-scaled-e1611311838349.jpg"

    )

    private val hrCategory = arrayOf(
            "MOVIE",
            "MOVIE",
            "MOVIE",
            "MOVIE",
            "MOVIE"
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
            "By Geeknews Indonesia",
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