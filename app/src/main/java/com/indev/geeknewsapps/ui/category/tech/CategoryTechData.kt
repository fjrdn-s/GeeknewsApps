package com.indev.geeknewsapps.ui.category.tech

import com.indev.geeknewsapps.ui._model.ModelData

object CategoryTechData {

    private val hrTitle = arrayOf(
            "B.I. Tech Eye Care Monitor untuk WFH & E-Learning",
            "Kingston Technology Memimpin Pengiriman SSD di tahun 2019",
            "Thrustmaster Siap Membawa Dunia Racing Game di Indonesia lebih Maju!",
            "Nikmati Immersive Gameplay dengan Laptop Gaming 15 inci GeForce RTX™",
            "Lenovo Indonesia Luncurkan Produk Terbaru Lenovo™ Legion"
    )

    private val hrDescription = arrayOf(
            "Geeknews.id – BenQ, penyedia perangkat digital lifestyle berskala internasional, mengumumkan Brightness Intelligence monitor GW2480T series yang dirancang untuk menyempurnakan gaya hidup minimalis modern, dengan teknologi perawatan mata terkemuka, dan desain yang mengutamakan kenyamanan pengguna. Dengan menggunakan B.I Tech Eye.\n" +
                    "\n" +
                    "Dengan ukuran layar 24″, BenQ GW2480T dapat menampilkan kualitas gambar Full HD 1080p yang memukau dalam pilihan teknologi panel IPS canggih dengan sudut pandang lebar 178 dan 5ms response times.",

            "Geeknews.id – Kingston Technology, salah satu pemimpin dunia dalam produk memori dan solusi teknologi, hari ini mengumumkan bisnis SSDnya yang terus tumbuh mengikuti tahun 2019 yang penuh kompetisi. Permintaan SSD sepanjang periode Q1 di tahun 2020 tetap tinggi karena pertumbuhan yang berkelanjutan dari sektor klien, perusahaan dan OEM. Sejak 2019, Kingston telah memperluas portofolio SSD-nya dengan tiga SSD klien baru, lima pusat data – dengan spefisik drive – dua di antaranya mencapai status VMware Ready ™ – dan meluncurkan solusi U.2 NVMe PCIe pertamanya.",

            "Geeknews.id – Thrustmaster Didirikan pada tahun 1992 dan dibeli oleh Guillemot Corporation pada tahun 1999, Thrustmaster dengan bangga membawa semua pengetahuan dan keahlian teknologi-nya ke pasaraksesoris video game. Selama hamper 20 tahun, Thrustmaster telah mengembangkan solusi untuk memuaskan dan menghibur para gamer. Dengan menciptakan produk untuk pengalaman bermain yang sangat advanced, seperti racing wheels dan unique joysticks. Untuk meningkatkan level realisme dan imersi ke dunia game legendaris, Thrustmaster lalu menekankan pada pengembangan produk dan aksesori yang didukung oleh lisensi international bergengsi, dengan mencerminkan moto “Passion, Innovation and Quality”, tujuan utama semangat Thrustmaster adalah untuk membuat pengguna menikmati pengamalan yang benar-benar luar biasa dengan produknya, dan mewujudkan impian mereka sebagai real gamer menjadi kenyataan.",

            "Geeknews.id – Lenovo Indonesia meluncurkan Legion Slim 7i berukuran 15 inci yang merupakan produk gaming Lenovo terbaru yang hadir di Indonesia di tahun 2021. Legion Slim 7i mendorong batas portabilitas dan performa sehingga para pengguna dapat meningkatkan level game di mana pun. Ditenagai oleh sampai dengan prosesor 8 core Intel® Core™ i7-10870H Series Generasi ke-10 dan grafis NVIDIA® GeForce® RTX, mesin gaming yang dirancang dengan baik ini mengemas kekuatan dan performa yang ganas di dalam sebuah perangkat yang sangat tipis dan ringan yang dapat dimasukkan dengan mudah ke dalam ransel.",

            "Lenovo Legion juga dihadirkan untuk mendukung kebutuhan mobilitas yang tinggi. “Sebagian masyarakat Indonesia saat ini sudah mulai bekerja dari kantor dan terbiasa bekerja secara mobile. Hal ini menandakan bahwa mereka membutuhkan perangkat yang mampu mendukung mobilitas yang tinggi. Produk Lenovo Legion terbaru kami adalah solusi yang memenuhi kebutuhan mobilitas mereka saat bekerja maupun mendukung aktivitas gaming saat waktu senggang, baik dari sisi performa yang luar biasa serta desain yang stylish. Hal ini juga wujud bagian komitmen Lenovo yang selalu menyediakan teknologi yang lebih cerdas bagi seluruh masyarakat di Indonesia—smarter technology for all,” kata Budi Janto, General Manager Lenovo Indonesia."

    )
    private val hrImages = arrayOf(
            "https://geeknews.id/wp-content/uploads/2020/06/gw2480t-eyecare-left45-e1592985124891.jpg",
            "https://geeknews.id/wp-content/uploads/2020/06/SSD-Fam-Shot-e1591601678336.jpg",
            "https://geeknews.id/wp-content/uploads/2018/12/IMG_20181217_113920-e1545121497529.jpg",
            "https://geeknews.id/wp-content/uploads/2021/02/Legion-Slim-7i-2-e1614067236105.png",
            "https://geeknews.id/wp-content/uploads/2020/06/Lenovo-Legion-X50-e1593155175313.png"

    )

    private val hrCategory = arrayOf(
            "TECH",
            "TECH",
            "TECH",
            "TECH",
            "TECH"
    )

    private val hrPostTime = arrayOf(
            "2 week ago",
            "1 hour ago",
            "1 mount ago",
            "1 week ago",
            "5 hour ago"
    )

    private val hrPostBy = arrayOf(
            "By Susilo Widiksono",
            "By Susilo Widiksono",
            "By Susilo Widiksono",
            "By Riyan Agustiar Sutardi",
            "By Susilo Widiksono"
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