# Dicoding_JetpackPro_03

<p align="center">
  <img src="https://user-images.githubusercontent.com/32255348/133293265-34c734c7-64f2-4884-b3c4-7ab2150d918b.gif" width="300" />
</p>

<p align="center"><i><b>Figure 1</b> Preview of The Movie Database App</i></p>

<br/>

Result of my Dicoding: "Belajar Android Jetpack Pro" Certificate (Submission 03: Kelola Data)

## Information
<p align="center">
  <img src="https://www.xda-developers.com/files/2021/03/Android-Jetpack.jpg" width="500"/>
</p>
<p align="center"><i><b>Figure 2</b> Android Jetpack Logo</i></p>

Type                  : Submission 03 - Final

Platform              : Mobile - [Android](https://www.android.com/intl/id_id/)

Programming Language  : [Kotlin](https://developer.android.com/kotlin?hl=id)

Dicoding Class        : [Belajar Android Jetpack Pro](https://www.dicoding.com/academies/129)

## Results for App 
| Action                            | Result                                  | Action                            | Result                                  |
| -------------                     |------------------                       | -------------                     |------------------                       |
| Movie List                        | <img src="https://user-images.githubusercontent.com/32255348/133293622-7d7324e1-0f24-4545-a629-6f5754ab5c02.gif" width="200" />      | TV Show List             | <img src="https://user-images.githubusercontent.com/32255348/133293705-5d421bd0-b124-4c77-a3df-68d3609bcc7e.gif" width="200" />      |
| Detail Page & Favorite Button     | <img src="https://user-images.githubusercontent.com/32255348/133293863-312f89dc-342b-438c-95ef-9ababa884733.gif" width="200" />      | Search Feature             | <img src="https://user-images.githubusercontent.com/32255348/133293943-9f7ef7c7-3736-415b-aa5d-3a241aa0b5e0.gif" width="200" />      |

## Testing Schenario - Indonesia language
- DetailMovieViewModelTest
  - Memuat Movie
    -	Memanipulasi data ketika pemanggilan data movie di kelas repository.
    -	Memastikan metode di kelas repository terpanggil.
    -	Melakukan pengecekan data movie apakah null atau tidak.
    -	Membandingkan data movie sudah sesuai dengan yang diharapkan atau tidak.
    
  -	Menambahkan movie ke dalam favorit
    -	Mengubah status favorit dalam movie ke dalam menjadi true (difavoritkan)
    -	Melakukan pengecekan data dalam database apakah sudah sesuai atau belum
    
  -	Menghapus movie dari daftar favorit
    -	Mengubah status favorit dalam movie ke dalam menjadi false (tidak difavoritkan)
    -	Melakukan pengecekan data dalam database apakah sudah sesuai atau belum
    
-	DetailTvShowViewModelTest
  -	Memuat Tv Show
    -	Memanipulasi data ketika pemanggilan data tv show di kelas repository.
    -	Memastikan metode di kelas repository terpanggil.
    -	Melakukan pengecekan data tv show apakah null atau tidak.
    -	Membandingkan data tv show sudah sesuai dengan yang diharapkan atau tidak.
    
  -	Memuat Tv Show with Season Detail
    -	Memanipulasi data ketika pemanggilan data tv show with season detail di kelas repository.
    -	Memastikan metode di kelas repository terpanggil.
    -	Melakukan pengecekan data tv show with season detail apakah null atau tidak.
    -	Membandingkan data tv show with season detail sudah sesuai dengan yang diharapkan atau tidak.
  -	Menambahkan tv show ke dalam favorit
    -	Mengubah status favorit dalam tv show ke dalam menjadi true (difavoritkan)
    -	Melakukan pengecekan data dalam database apakah sudah sesuai atau belum
  -	Menghapus tv show dari daftar favorit
    -	Mengubah status favorit dalam tv show ke dalam menjadi false (tidak difavoritkan)
    -	Melakukan pengecekan data dalam database apakah sudah sesuai atau belum

-	MovieViewModelTest
  -	Memuat list movie
    -	Memanipulasi data ketika pemanggilan data list movie di kelas repository.
    -	Memastikan metode di kelas repository terpanggil.
    -	Melakukan pengecekan data list movie apakah null atau tidak.
    -	Melakukan pengecekan jumlah data movie apakah sudah sesuai atau belum.
-	TvShowViewModelTest
  -	Memuat list tv show
    -	Memanipulasi data ketika pemanggilan data list tv show di kelas repository.
    -	Memastikan metode di kelas repository terpanggil.
    -	Melakukan pengecekan data list tv show apakah null atau tidak.
    -	Melakukan pengecekan jumlah data list tv show apakah sudah sesuai atau belum.

-	TmdbRepositoryTest
  -	Memuat List Movie
    -	Memanipulasi data ketika pemanggilan list movie dengan data dummy
    -	Memastikan metode pemanggilan list movie terpanggil
    -	Melakukan pengecekan data list movie apakah null atau tidak
    -	Melakukan pengecekan jumlah list movie apakah sudah sesuai atau belum
  -	Memuat List Tv Show
    -	Memanipulasi data ketika pemanggilan list tv show dengan data dummy
    -	Memastikan metode pemanggilan list tv show terpanggil
    -	Melakukan pengecekan data list tv show apakah null atau tidak
    -	Melakukan pengecekan jumlah list tv show apakah sudah sesuai atau belum
  -	Memuat Detail Movie
    -	Memanipulasi data ketika pemanggilan detail movie dengan data dummy
    -	Memastikan metode pemanggilan detail movie terpanggil
    -	Melakukan pengecekan data detail movie apakah null atau tidak
    -	Melakukan pengecekan Id Movie pada detail movie apakah sudah sesuai atau belum
  -	Memuat Detail Tv Show
    -	Memanipulasi data ketika pemanggilan detail tv show dengan data dummy
    -	Memastikan metode pemanggilan detail tv show terpanggil
    -	Melakukan pengecekan data detail tv show apakah null atau tidak
    -	Melakukan pengecekan Id Tv Show pada detail tv show apakah sudah sesuai atau belum
  -	Memuat Detail Tv Show dengan Season Detail
    -	Memanipulasi data ketika pemanggilan Tv Show with Season Detail dengan data dummy
    -	Memastikan metode pemanggilan Tv Show with Season Detail terpanggil
    -	Melakukan pengecekan data Tv Show with Season Detail apakah null atau tidak
    -	Melakukan pengecekan Id Tv Show pada Tv Show with Season Detail apakah sudah sesuai atau belum
  -	Memuat List Favorite Movie
    -	Memanipulasi data ketika pemanggilan list movie favorite dengan data dummy
    -	Memastikan metode pemanggilan list movie favorite terpanggil
    -	Melakukan pengecekan data list movie favorite apakah null atau tidak
    -	Melakukan pengecekan Id movie pada list movie favorite apakah sudah sesuai atau belum
  -	Memuat List Favorite Tv Show
    -	Memanipulasi data ketika pemanggilan list tv show favorite dengan data dummy
    -	Memastikan metode pemanggilan list tv show favorite terpanggil
    -	Melakukan pengecekan data list tv show favorite apakah null atau tidak
    -	Melakukan pengecekan Id tv show pada list tv show favorite apakah sudah sesuai atau belum
  -	Menambahkan movie ke dalam favorit Movie
    -	Mengubah status favorit dalam data movie menjadi true
    -	Melakukan pengecekan data dalam database apakah sudah sesuai atau belum
  -	Menambahkan tv show ke dalam favorit Tv show
    -	Mengubah status favorit dalam data tv show menjadi true
    -	Melakukan pengecekan data dalam database apakah sudah sesuai atau belum
  -	Menghapus movie dari daftar favorit
    -	Mengubah status favorit dalam data movie menjadi false
    -	Melakukan pengecekan data dalam database apakah sudah sesuai atau belum
  -	Menghapus tv show dari daftar favorit Tv show
    -	Mengubah status favorit dalam data tv show menjadi false
    -	Melakukan pengecekan data dalam database apakah sudah sesuai atau belum
    
------------------------------------------------------------------------------

-	Menampilkan data list movie
    -	Klik bottom navigation untuk bagian movie
    -	Memastikan rv_movie dalam keadaan tampil
    -	Gulir rv_movie ke posisi data terakhir
  
-	Menampilkan halaman detail movie
    -	Klik bottom navigation untuk bagian movie
    -	Memberi tindakan klik pada data pertama di rv_movie
    -	Memastikan TextView untuk keterangan halaman (Top title) dapat ditampilkan
    -	Memastikan TextView untuk judul movie dapat ditampilkan
    -	Memastikan RatingBar untuk movie dapat ditampilkan
    -	Memastikan TextView durasi movie dapat ditampilkan
    -	Memastikan TextView synopsis movie dapat ditampilkan
    -	Memastikan ImageButton untuk Movie Favorit dapat ditampilkan
    -	Memastikan ImageView untuk movie backdrop dapat ditampilkan
    -	Memastikan ImageView untuk poster movie dapat ditampilkan
    -	Memberikan Tindakan klik pada tombol back di halaman detail movie

-	Menampilkan data list tv show
    -	Klik bottom navigation untuk bagian Tv Show
    -	Memastikan rv_tvShow dalam keadaan tampil
    -	Gulir rv_tvShow ke posisi data terakhir
  
-	Menampilkan halaman detail tv show
    -	Klik bottom navigation untuk bagian Tv Show
    -	Memberi tindakan klik pada data pertama di rv_tvShow
    -	Memastikan TextView untuk keterangan halaman (Top title) dapat ditampilkan
    -	Memastikan TextView untuk judul tv show dapat ditampilkan
    -	Memastikan RatingBar untuk tv show rating dapat ditampilkan
    -	Memastikan TextView tanggal perilisan tv show dapat ditampilkan
    -	Memastian TextView durasi dapat ditampilkan
    -	Memastikan TextView synopsis tv show dapat ditampilkan
    -	Memastikan ImageButton untuk tv show Favorit dapat ditampilkan
    -	Memastikan ImageView untuk tv show backdrop dapat ditampilkan
    -	Memastikan ImageView untuk poster tv show dapat ditampilkan
    -	Memastikan rv_seasonDetail dapat ditampilkan
    -	Memberikan Tindakan klik pada tombol back di halaman detail tv show

-	Menampilkan hasil ekspansi dan menutup kembali daftar movie
    -	Klik bottom navigation untuk bagian movie
    -	Menekan tombol ekspansi pada halaman list movie untuk memperluas tampilan halaman list movie
    -	Menekan tombol ekspansi kembali pada halaman list movie untuk mengembalikan tampilan halaman list movie (setengah halaman)

-	Menampilkan hasil ekspansi dan menutup kembali daftar tv show
    -	Klik bottom navigation untuk bagian Tv Show
    -	Menekan tombol ekspansi pada halaman list tv show untuk memperluas tampilan halaman list tv show
    -	Menekan tombol ekspansi kembali pada halaman list tv show untuk mengembalikan tampilan halaman list tv show (setengah halaman)
