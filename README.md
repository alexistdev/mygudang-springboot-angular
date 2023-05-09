# mygudang-springboot-angular-android
Aplikasi Stok Gudang dengan SpringBoot dan Angular [masih on proses]

## REST API INFO:
- Springboot 3.0.3
- JDK 19
- Maven
- Example endpoint : localhost:8080/users?id=1

## Installasi springboot:
- git clone : https://github.com/alexistdev/mygudang-springboot-angular.git
- buka folder : data-master-springboot
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

## Installasi Angular:
- Buka directory frontend setelah anda clone
- jalankan terminal dan ketik: npm install
- jalankan terminal dan ketik: ng serve
- username: alexistdev@gmail.com
- password: 1234

<table>
<tr>
<td><img src="https://i.postimg.cc/hjJ7Qr2q/back.png" /></td>
</tr>
</table>

## Installasi Android:

## EndPoint RESTAPI
<table>
<thead>
    <tr>
<th>No</th>
<th>EndPoint</th>
        <th>Deskripsi</th>
<th>Method</th>
<th>Payload</th>
</tr>
    </thead>
    <tbody>
<tr>
<td>1</td>
<td>Tambah Permission</td>
<td>http://localhost:8082/api/permission</td>
<td>
         POST
</td>
<td>
    {
    "slug" : "/wakanda",
    "role" : {
        "id" : 1,
        "name": "Admin",
        "level": 1
    }
}
</td>
</tr>
        
<tr>
<td>2</td>
<td>Tambah User</td>
<td>http://localhost:8082/api/users</td>
    <td>POST</td>   
   <td>
    {
    "name": "alex",
    "email": "alexistdev@gmail.com",
    "phone": "082371408678",
    "password": "12345",
    "isActive": 1
}
    </td>           
</tr>
    </tbody>
</table>
