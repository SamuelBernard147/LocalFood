package com.samuelbernard147.LocalFood;

import java.util.ArrayList;

public class MakananData {
    public static String[][] data = new String[][]{
            {"http://cdn2.tstatic.net/style/foto/bank/images/nasi-goreng_20160928_212733.jpg","Nasi Goreng","Nasi goreng adalah sebuah makanan berupa nasi yang digoreng dan diaduk dalam minyak goreng atau margarin, biasanya ditambah kecap manis, bawang merah, bawang putih, asam jawa, lada dan bumbu-bumbu lainnya, seperti telur, ayam, dan kerupuk. Ada pula nasi goreng jenis lain yang dibuat bersama ikan asin yang juga populer di seluruh Indonesia.","Panas","Nasi, Telur, Cabai, Garam dapur, Bawang merah,","Beragam variasi di seluruh Indonesia"},
            {"https://upload.wikimedia.org/wikipedia/commons/thumb/3/30/Gado-gado_in_Jakarta.JPG/1200px-Gado-gado_in_Jakarta.JPG","Gado Gado","Gado-gado adalah salah satu makanan yang berasal dari Betawi yang berupa sayur-sayuran yang direbus dan dicampur jadi satu, dengan bumbu kacang atau saus dari kacang tanah dan yang dihaluskan disertai irisan telur dan pada umumnya banyak yang menambahkan kentang rebus yang sudah dihaluskan untuk saus gado gado","Panas","Sayuran, Tahu, Tempe, Telur rebus","Gado-gado Padang, Gado-gado Bumbu Petis Sidoarjo, Gado-gado Uleg Legit Cirebon, Sushi-Gado"},
            {"http://www.dapurkobe.co.id/wp-content/uploads/sate-ayam.jpg","Sate","Sate adalah makanan yang terbuat dari potongan daging kecil-kecil yang ditusuk sedemikian rupa dengan tusukan lidi tulang daun kelapa atau bambu kemudian dipanggang menggunakan bara arang kayu. Sate disajikan dengan berbagai macam bumbu yang bergantung pada variasi resep sate. Daging yang dijadikan sate antara lain daging ayam, kambing, domba, sapi, babi, kelinci, kuda, dan lain-lain.","Panas","Berbagai potongan daging yang ditusuk bambu dengan berbagai bumbu","Variasi beragam di seluruh Nusantara dan Asia Tenggara"},
            {"https://cdn0-production-images-kly.akamaized.net/1PD7o3-3NNDOe2RTJs9qX1KZqlc=/640x360/smart/filters:quality(75):strip_icc():format(jpeg)/kly-media-production/medias/2051963/original/071114000_1522751934-Resep-Rendang-Ayam-Kering.jpg","Rendang","Rendang atau randang adalah masakan daging bercita rasa pedas yang menggunakan campuran dari berbagai bumbu dan rempah-rempah. Masakan ini dihasilkan dari proses memasak yang dipanaskan berulang-ulang dengan santan kelapa. Proses memasaknya memakan waktu berjam-jam (biasanya sekitar empat jam) hingga kering dan berwarna hitam pekat. Dalam suhu ruangan, rendang dapat bertahan hingga berminggu-minggu.","Panas atau suhu ruangan","Daging sapi, santan kelapa, cabai, bumbu","Rendang ayam, rendang itik (bebek), rendang hati sapi"},
            {"https://cdn0-production-images-kly.akamaized.net/aDZbOOV2WeJCgCiBFgFQwoXJN64=/640x360/smart/filters:quality(75):strip_icc():format(jpeg)/kly-media-production/medias/2029093/original/066661300_1521949447-Bakso.jpg","Bakso","Bakso atau baso adalah jenis bola daging yang lazim ditemukan pada masakan Indonesia. Bakso umumnya dibuat dari campuran daging sapi giling dan tepung tapioka, akan tetapi ada juga bakso yang terbuat dari daging ayam, ikan, atau udang bahkan daging kerbau. Dalam penyajiannya, bakso umumnya disajikan panas-panas dengan kuah kaldu sapi bening, dicampur mi, bihun, taoge, tahu, terkadang telur dan ditaburi bawang goreng dan seledri.","Panas","Daging, tepung tapioka, mi, bihun, tahu, kailan, acar, seledri, bawang goreng","Bakso Malang"},
            {"https://cdn0-production-images-kly.akamaized.net/6b2SY-0HclmCscFG-bEk4AI6V1E=/640x360/smart/filters:quality(75):strip_icc():format(jpeg)/kly-media-production/medias/1903118/original/015977700_1518697892-Soto_Ayam_2.jpg","Soto Ayam","Soto ayam adalah makanan khas Indonesia yang berupa sejenis sup ayam dengan kuah yang berwarna kekuningan. Warna kuning ini dikarenakan oleh kunyit yang digunakan sebagai bumbu. Soto ayam banyak ditemukan di daerah-daerah di Indonesia dan Singapura. Selain ayam bahan yang digunakan juga meliputi telur rebus, irisan kentang, daun seledri, serta bawang goreng.","Panas","Daging Ayam, telur rebus, irisan kentang, daun seledri, bawang goreng","Soto Ayam Kampung, Soto Ayam Koya, Soto Kudus"}

    };
    public static ArrayList<Makanan>getListData(){
        Makanan makanan = null;
        ArrayList<Makanan>list = new ArrayList<>();
        for (int i = 0; i < data.length; i++ ){
            makanan = new Makanan();
            makanan.setGambar(data[i][0]);
            makanan.setNama(data[i][1]);
            makanan.setDeskripsi(data[i][2]);
            makanan.setPenyajian(data[i][3]);
            makanan.setBahan(data[i][4]);
            makanan.setVariasi(data[i][5]);

            list.add(makanan);
        }
        return list;
    }
}