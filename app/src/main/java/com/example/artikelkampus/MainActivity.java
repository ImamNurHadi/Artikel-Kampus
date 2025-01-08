package com.example.artikelkampus;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.PopupMenu;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<Article> articles = Arrays.asList(
                new Article(R.drawable.itb, "Institut Teknologi Bandung",
                        "Overview singkat ITB.",
                        "Institut Teknologi Bandung (ITB) adalah salah satu perguruan tinggi terkemuka di Indonesia, yang terletak di Bandung, Jawa Barat. Dikenal dengan program studi di bidang teknologi dan seni, ITB berfokus pada pengembangan ilmu pengetahuan, riset, dan teknologi untuk membangun masa depan bangsa.",
                        1920),

                new Article(R.drawable.its, "Institut Teknologi Sepuluh Nopember",
                        "Overview singkat ITS.",
                        "Institut Teknologi Sepuluh Nopember (ITS) terletak di Surabaya, Jawa Timur. ITS adalah universitas teknik yang menawarkan berbagai program studi di bidang teknik, ilmu komputer, dan teknologi. ITS berkomitmen untuk menghasilkan lulusan yang berdaya saing tinggi di dunia industri.",
                        1960),

                new Article(R.drawable.ub, "Universitas Brawijaya",
                        "Overview Universitas UB.",
                        "Universitas Brawijaya (UB) adalah universitas negeri yang berada di Malang, Jawa Timur. UB dikenal dengan berbagai fakultas yang beragam, mulai dari ilmu sosial, ekonomi, teknik, hingga kedokteran. UB memiliki reputasi dalam penelitian dan pengabdian masyarakat.",
                        1963),

                new Article(R.drawable.ugm, "Universitas Gadjah Mada",
                        "Overview Universitas UGM.",
                        "Universitas Gadjah Mada (UGM) adalah universitas negeri yang terletak di Yogyakarta, Indonesia. Didirikan pada tahun 1949, UGM memiliki berbagai program studi di bidang ilmu pengetahuan dan teknologi, serta memiliki peran penting dalam pengembangan riset di Indonesia.",
                        1949),

                new Article(R.drawable.ui, "Universitas Indonesia",
                        "Overview Universitas UI.",
                        "Universitas Indonesia (UI) adalah universitas terbesar di Indonesia yang terletak di Depok, Jawa Barat. UI menawarkan berbagai program sarjana dan pascasarjana di berbagai disiplin ilmu, serta memiliki reputasi internasional dalam dunia akademik.",
                        1849),

                new Article(R.drawable.uii, "Universitas Islam Indonesia",
                        "Overview Universitas UII.",
                        "Universitas Islam Indonesia (UII) adalah universitas swasta yang terletak di Yogyakarta. Dikenal dengan fokus pada pendidikan Islam, UII juga menawarkan berbagai program studi di bidang ilmu sosial, ekonomi, dan teknik.",
                        1945),

                new Article(R.drawable.uinsa, "Universitas Islam Negeri Surabaya",
                        "Overview Universitas UINSA.",
                        "Universitas Islam Negeri Sunan Ampel Surabaya (UINSA) adalah sebuah universitas yang terletak di Surabaya, Jawa Timur. UINSA memiliki visi untuk memajukan ilmu pengetahuan dengan pendekatan Islam yang moderat, serta menyediakan pendidikan berkualitas di berbagai bidang.",
                        1965),

                new Article(R.drawable.unair, "Universitas Airlangga",
                        "Overview Universitas UNAIR.",
                        "Universitas Airlangga (UNAIR) adalah universitas negeri yang terletak di Surabaya, Jawa Timur. UNAIR terkenal dengan program-program unggulannya di bidang kesehatan, kedokteran, hukum, dan ilmu sosial. Universitas ini terus berinovasi dalam riset dan pengabdian masyarakat.",
                        1954),

                new Article(R.drawable.unesa, "Universitas Negeri Surabaya",
                        "Overview Universitas UNESA.",
                        "Universitas Negeri Surabaya (UNESA) merupakan universitas negeri yang fokus pada pendidikan dan pengajaran. Terletak di Surabaya, UNESA juga dikenal dengan kontribusinya dalam bidang olahraga dan seni, dengan berbagai program yang mendukung pengembangan kreativitas mahasiswa.",
                        1964),

                new Article(R.drawable.unm, "Universitas Negeri Malang",
                        "Overview Universitas UNM.",
                        "Universitas Negeri Malang (UNM) adalah universitas negeri yang terletak di Malang, Jawa Timur. UNM memiliki program studi unggulan di bidang pendidikan, ilmu sosial, dan ekonomi. Universitas ini berkomitmen untuk menghasilkan lulusan yang kompeten dan siap menghadapi tantangan global.",
                        1954)
        );

        ArticleAdapter adapter = new ArticleAdapter(articles, article -> {
            // Mengirim objek artikel ke DetailActivity
            Intent intent = new Intent(MainActivity.this, DetailActivity.class);
            intent.putExtra("ARTICLE", article);  // Menggunakan Parcelable
            startActivity(intent);
        });

        recyclerView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.about_page) {
            Intent intent = new Intent(MainActivity.this, AboutActivity.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}