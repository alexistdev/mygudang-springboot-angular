# mygudang-springboot-angular
Aplikasi Stok Gudang dengan SpringBoot dan Angular [masih on proses]

## REST API INFO:
- Springboot 3.0.3
- JDK 19
- Maven
- Example endpoint : localhost:8080/users?id=1

## Installasi springboot:
- git clone : https://github.com/alexistdev/mygudang-springboot-angular.git
- Jalankan Xampp dan Buat database kosong dengan nama: mygudang
- ketik di terminal : mvn install
- Jalankan springboot : springboot:run
- Buka postman dan test dengan menjalankan tambah user [post] localhost:8000/api/users,
pilih body -> raw ->json
- contoh json untuk menambah data user nya :

<pre>
{
    "name": "alex",
    "email": "alexistdev@gmail.com",
    "phone": "082371408678",
    "password": "12345",
    "isActive": 1
}
</pre>

<table>
<tr>
<td><img src="https://i.postimg.cc/mDN2mkLp/postman2.png" /></td>
</tr>
<tr>
<td><img src="https://i.postimg.cc/dtqP2nTY/postman6.png" /></td>
</tr>
</table>

