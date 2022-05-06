package com.doxx.rankershalt

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_jee_books_list.*
import java.util.*

class JeeTestPaperFragment: Fragment(R.layout.fragment_jee_books_list),ItemClicked {
    lateinit var adapter:Adapter
    lateinit var imageId:Array<Int>
    lateinit var bookName:Array<String>
    lateinit var links:Array<String>
    lateinit var bookArrayList: ArrayList<Books>

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        ecy.layoutManager= LinearLayoutManager(context)

        bookName= arrayOf(
            "FIITJEE AITS JEE MAIN TP-1",
            "FIITJEE AITS JEE MAIN TP-2",
            "FIITJEE AITS JEE MAIN TP-3",
            "FIITJEE JEE ADVANCED AITS TP-2 Paper 1",
            "FIITJEE JEE ADVANCED AITS TP-2 Paper 2",
            "FIITJEE JEE ADVANCED TP-1 Paper 1",
            "FIITJEE JEE ADVANCED TP-1 Paper 2",
            "Narayana JEE ADVANCED TP-1 Paper 1",
            "Narayana JEE ADVANCED TP-1 Paper 2",
            "Narayana JEE ADVANCED TP-2 Paper 1",
            "Narayana JEE ADVANCED TP-2 Paper 2",
            "Narayana JEE ADVANCED TP-3 Paper 1",
            "Narayana JEE ADVANCED TP-3 Paper 2",
            "Narayana JEE ADVANCED TP-4 Paper 1",
            "Narayana JEE ADVANCED TP-4 Paper 2",
            "Narayana JEE ADVANCED TP-5 Paper 1",
            "Narayana JEE ADVANCED TP-5 Paper 2",
            "Narayana JEE ADVANCED TP-6 Paper 1",
            "Narayana JEE ADVANCED TP-6 Paper 2",
            "Narayana JEE ADVANCED TP-7 Paper 1",
            "Narayana JEE ADVANCED TP-7 Paper 2",
            "Narayana JEE ADVANCED TP-8 Paper 1",
            "Narayana JEE ADVANCED TP-8 Paper 2",
            "Narayana JEE ADVANCED TP-9 Paper 1",
            "Narayana JEE ADVANCED TP-9 Paper 2",
            "Narayana JEE ADVANCED TP-10 Paper 1",
            "Narayana JEE ADVANCED TP-10 Paper 2",
            "Narayana JEE ADVANCED TP-11 Paper 1",
            "Narayana JEE ADVANCED TP-11 Paper 2",
            "Narayana JEE ADVANCED TP-12 Paper 1",
            "Narayana JEE ADVANCED TP-12 Paper 2",
            "Narayana JEE ADVANCED TP-13 Paper 1",
            "Narayana JEE ADVANCED TP-13 Paper 2",
            "Narayana JEE ADVANCED TP-14 Paper 1",
            "Narayana JEE ADVANCED TP-14 Paper 2",
            "Narayana JEE ADVANCED TP-15 Paper 1",
            "Narayana JEE ADVANCED TP-15 Paper 2",
            "Narayana JEE ADVANCED TP-16 Paper 1",
            "Narayana JEE ADVANCED TP-16 Paper 2",
            "Narayana JEE ADVANCED TP-17 Paper 1",
            "Narayana JEE ADVANCED TP-17 Paper 2",
            "Narayana JEE ADVANCED TP-18 Paper 1",
            "Narayana JEE ADVANCED TP-18 Paper 2",
            "Narayana JEE MAIN TP-01",
            "Narayana JEE MAIN TP-02",
            "Narayana JEE MAIN TP-03",
            "Narayana JEE MAIN TP-04",
            "Narayana JEE MAIN TP-05",
            "Narayana JEE MAIN TP-06",
            "Narayana JEE MAIN TP-07",
            "Narayana JEE MAIN TP-08",
            "Narayana JEE MAIN TP-09",
            "Narayana JEE MAIN TP-10",
            "Narayana JEE MAIN TP-11",
            "Narayana JEE MAIN TP-12",
            "Narayana JEE MAIN TP-13",
            "Narayana JEE MAIN TP-14",
            "Narayana JEE MAIN TP-15",
            "Narayana JEE MAIN TP-16",
            "Narayana JEE MAIN TP-17",
            "Narayana JEE MAIN TP-18",
            "Narayana JEE MAIN TP-19",
            "Sri Chaitanya JEE ADVANCED TP-1 Paper 1",
            "Sri Chaitanya JEE ADVANCED TP-1 Paper 2",
            "Sri Chaitanya JEE MAIN TP-01",
            "Sri Chaitanya JEE MAIN TP-02",
            "Sri Chaitanya JEE MAIN TP-03",
            "Sri Chaitanya JEE MAIN TP-04",
            "Sri Chaitanya JEE MAIN TP-05",
            "Sri Chaitanya JEE MAIN TP-06",
            "Sri Chaitanya JEE MAIN TP-07",
            "Sri Chaitanya JEE MAIN TP-08",
            "Sri Chaitanya JEE MAIN TP-09",
            "Sri Chaitanya JEE MAIN TP-10",
            "Sri Chaitanya JEE MAIN TP-11",
            "Sri Chaitanya JEE MAIN TP-12",
            "Sri Chaitanya JEE MAIN TP-13",
            "Sri Chaitanya JEE MAIN TP-14",
            "Sri Chaitanya JEE MAIN TP-15",
            "Sri Chaitanya JEE MAIN TP-16",
            "Sri Chaitanya JEE MAIN TP-17",
            "Sri Chaitanya JEE MAIN TP-18",
            "Sri Chaitanya JEE MAIN TP-19",
            "Sri Chaitanya JEE MAIN TP-20"
        )
        links= arrayOf(
            "https://drive.google.com/uc?export=download&id=1lF5lGUrFw3m3HpbF89Wi4ov1KOxVndQw",
            "https://drive.google.com/uc?export=download&id=16idtEQQbJg7JQvyF18zzBFPldQxVEG4d",
            "https://drive.google.com/uc?export=download&id=1eCwsFAfUN85J3ayacaFcxECiys3F3T8u",
            "https://drive.google.com/uc?export=download&id=1TuRrNR3hekvx_VGGF6w0Mx4BrAuLFILy",
            "https://drive.google.com/uc?export=download&id=1c4duN8a44gpeieNKbCSXd_yRt-Km8L02",
            "https://drive.google.com/uc?export=download&id=1ODm5gxakvRZtt9frdRbOR_IZXJJRRNLC",
            "https://drive.google.com/uc?export=download&id=1J6jOqLJYaj6MZIZH0Xh2-KO0EmkrenX3",
            "https://drive.google.com/uc?export=download&id=1kntXBfxsbRQOuAdLp61jS8zWVT8QaIs1",
            "https://drive.google.com/uc?export=download&id=1DhJ94XpoykKqnDM_36hFj8OCncE1xf32",
            "https://drive.google.com/uc?export=download&id=1eG1pOOJ4okeoE0JXkZkqrFVQGfdaOGSz",
            "https://drive.google.com/uc?export=download&id=1G0VzqvvveeZ7MknXAxbkZCybyvkJWxxI",
            "https://drive.google.com/uc?export=download&id=1vtHpX1AJ9fRnubte4FqcRjUfHxTtCj3d",
            "https://drive.google.com/uc?export=download&id=1C5ZW21umL2OOLvYensmlyimFe1i7JAh6",
            "https://drive.google.com/uc?export=download&id=1FKSwig0kWlap65v9HSh5hJ8NiQNRkY2A",
            "https://drive.google.com/uc?export=download&id=1i3Au2ITRS2rJs8kYV21sm52_0RQW6WSJ",
            "https://drive.google.com/uc?export=download&id=1HtDmPLJsQNAR5Y4mgf8RsWvzJdOjun3s",
            "https://drive.google.com/uc?export=download&id=1y0f4bcgCOsdgIG2OXtiP1__p_c-_JpUu",
            "https://drive.google.com/uc?export=download&id=16Xz68zRsjyxnIEcg-OjB2xszYgq-ob-_",
            "https://drive.google.com/uc?export=download&id=1gRiloLQfUD4P00wflDarbACQ6T9reiLf",
            "https://drive.google.com/uc?export=download&id=1bJslKeL9BSw6YLTCXzAcL_o2Uto6bWBu",
            "https://drive.google.com/uc?export=download&id=1FFfCD4JWfzElfvz35IKY1Ml3EcRrxoIF",
            "https://drive.google.com/uc?export=download&id=1vBIvFAIBFeG81qmSgVmdEdGfWpU_Ht60",
            "https://drive.google.com/uc?export=download&id=15m7xaAle4loChdjexifGR9FVYeBVM5Dc",
            "https://drive.google.com/uc?export=download&id=1hzM6M7Lx6K9kFu1DGrZ_Os6oYKm7gLhS",
            "https://drive.google.com/uc?export=download&id=12CECnwN7d5RABsfNiqhCZefiAQQUUISC",
            "https://drive.google.com/uc?export=download&id=1khWkvIO9qT-UUHZafdSJtRSy5vFg-9Mg",
            "https://drive.google.com/uc?export=download&id=1evsRV-J3TbR6DywCF3xEyzjgq-qrFCX4",
            "https://drive.google.com/uc?export=download&id=1JPgZk1ATLpDQY27yvJLE18D1fV0Se57M",
            "https://drive.google.com/uc?export=download&id=1--RfD7fuGhJNFpeww3oACOn-LpS2iPQ2",
            "https://drive.google.com/uc?export=download&id=17auZvH0NPmErHh7Q9r_2oxAJeymgVMf4",
            "https://drive.google.com/uc?export=download&id=1Ywjjv5k4xOh-Kift_4UYkn_EMaAkCLYJ",
            "https://drive.google.com/uc?export=download&id=1CkT0BE_0tN0plRkSX-3rEM6WqiHpTzAo",
            "https://drive.google.com/uc?export=download&id=1_P86gF7GAWXGmoMVn530o0ScIF0e_4xB",
            "https://drive.google.com/uc?export=download&id=1YQ0B_7vuwRaVgHn5XOY8_Zo1OvEzKQqN",
            "https://drive.google.com/uc?export=download&id=1MDQdUlcgTVRfXSDepzamubkspc9KBYRa",
            "https://drive.google.com/uc?export=download&id=1KayAdgXKyv4x9BsVg_TjLxNyFCMI04xe",
            "https://drive.google.com/uc?export=download&id=1w_6HJSb3gx6WpVA7fUAYVHtpxHghxv9X",
            "https://drive.google.com/uc?export=download&id=1GajKbm4mx3zGFV-y24qMjZzd3aXok9Wt",
            "https://drive.google.com/uc?export=download&id=1m4LMP6SxRCYkqAC7iTRhP3RbvFPcy263",
            "https://drive.google.com/uc?export=download&id=19VcrifpuTPwPrJInptlZdFQW7P9EZ87H",
            "https://drive.google.com/uc?export=download&id=1iwGTq7X8DxS0Mc_Zwwd7NnpEP3_xacIu",
            "https://drive.google.com/uc?export=download&id=1axCehE4RsdrSeEy8w-DoS4o7kuwmxQTk",
            "https://drive.google.com/uc?export=download&id=1UC0TWTffFXbcIl93u2-C_v65zY7ENcBA",
            "https://drive.google.com/uc?export=download&id=118P-ymDDErXTou14Ijngo_8L808Q8_FV",
            "https://drive.google.com/uc?export=download&id=1IECDuR38wBXvVMR9J1Mz2jPNF6_CHE1k",
            "https://drive.google.com/uc?export=download&id=1ya_0q1HIRLg0f6hnYueG9PBIGeHdt-Qo",
            "https://drive.google.com/uc?export=download&id=1BM5m1-Ff3qQFqzIt4H7BnkN9IXEe1F_y",
            "https://drive.google.com/uc?export=download&id=1BbmUi8V1a0zvMeUi_POKS_p-4GCgy5pi",
            "https://drive.google.com/uc?export=download&id=1ne8c3VprPj7F7Q5pZYwVEhKTx8F03RXc",
            "https://drive.google.com/uc?export=download&id=15fpPKnUnSD0UMAh6yzZX3T6R5SGfWbX-",
            "https://drive.google.com/uc?export=download&id=1K1vHcAxuyeuKrccTqB67segbgMLB00er",
            "https://drive.google.com/uc?export=download&id=196rQMilVXTDqPX3tPBaIuztH7e_vZZw0",
            "https://drive.google.com/uc?export=download&id=1MpCNiC2i1cVD28TOiCkHYP-ZdKXZLHt8",
            "https://drive.google.com/uc?export=download&id=1ByG9zNFZiR59EqUYfJEm396mY8NZ2mKR",
            "https://drive.google.com/uc?export=download&id=1lWFvgM-tSGylQZ9U_csc1KCGoBGe6h_G",
            "https://drive.google.com/uc?export=download&id=1-Pb-j3sMLniKWY801je35DZwAG_wwGUs",
            "https://drive.google.com/uc?export=download&id=1hrviWXAAOxFafl5zJWUw-fyX1k65W3xU",
            "https://drive.google.com/uc?export=download&id=1pDRna_k8VG0Jv7X_orwRJb1BsYcReFoY",
            "https://drive.google.com/uc?export=download&id=1qXebwNpov9N51KsgvqEy_rjH-LaLg-HR",
            "https://drive.google.com/uc?export=download&id=185oj1YhrdxfxNK3HrdAY96NOSQ39l_-e",
            "https://drive.google.com/uc?export=download&id=1160iS3OEx-sWRtrOdBdDVTCw5yRWUTnK",
            "https://drive.google.com/uc?export=download&id=1VR3Az70L-_mlmZKCbSyFA143xnA-0x6W",
            "https://drive.google.com/uc?export=download&id=1AIRcZJ9JJTb8ssc3nf_Lu_v9KEgJXCZb",
            "https://drive.google.com/uc?export=download&id=1vzy_Qe9hhvT2N-bgC1ttAlz18zDJwHCa",
            "https://drive.google.com/uc?export=download&id=1yfYjlh05CY-pdCQB4GVNPatrwLlu5EwP",
            "https://drive.google.com/uc?export=download&id=1t8sE1zCEHaVEw-qLaCBxPC8zbkSz8Zg-",
            "https://drive.google.com/uc?export=download&id=1wZD0caeOYH4SAPiO5WO5zLu0NIf-3OIZ",
            "https://drive.google.com/uc?export=download&id=1zdcAGG12xQiqlg0e9bwHU_JUTq0OqUiY",
            "https://drive.google.com/uc?export=download&id=19iUmYRE6JumS13pzLag2VolDcE4fMHvg",
            "https://drive.google.com/uc?export=download&id=13zkSwb3des9C3v0tOSJHJ_0XzP55fLl7",
            "https://drive.google.com/uc?export=download&id=1wYSpvUMA7YchUYCruYzX294k2XW2j5zU",
            "https://drive.google.com/uc?export=download&id=1UZZPrcCDwcAE9XkwlYFJpqwxvufWgFT6",
            "https://drive.google.com/uc?export=download&id=1D_NcdyotUqlHsi4-Y_xITpNOOtNr90Yy",
            "https://drive.google.com/uc?export=download&id=1yr-Ma4tIDaQVRAIzAL0j_dFPW6xY1Eqs",
            "https://drive.google.com/uc?export=download&id=100yYDwbNw3TGxDMWTES-tc-8lGx00E73",
            "https://drive.google.com/uc?export=download&id=1a5d672_pRClOoaMJ23GZtgOIp8ai27uQ",
            "https://drive.google.com/uc?export=download&id=1a4DqIFQSWXy4T6tacs1-63FOQjY3gdlX",
            "https://drive.google.com/uc?export=download&id=1orSp0QNPKOMDd26xSxOVDZrLtgLBMxTE",
            "https://drive.google.com/uc?export=download&id=1pPneIGGK2mKcyh649gv1XLXrgy344oxO",
            "https://drive.google.com/uc?export=download&id=1eKCYz0dUOp_jkrwl36ZfL6OEHgRMDv6s",
            "https://drive.google.com/uc?export=download&id=11bZw_MUHSh0VN6DKP5ImxFnmwIic5QTc",
            "https://drive.google.com/uc?export=download&id=1DSgbgJp7m9vZySjoJxG0r1aZns_jUYHp",
            "https://drive.google.com/uc?export=download&id=1MTJ4uBq5rHbGaSQKhKoA9E3guCN9JYDs",
            "https://drive.google.com/uc?export=download&id=1puEztuLTYha3QA6dmwLu222DxY-wahDs"

        )
        bookArrayList= arrayListOf()
        fetchData()
        var temp = ArrayList<Books>()
        temp.addAll(bookArrayList)
        adapter= Adapter(bookArrayList,this)
        ecy.adapter=adapter
        bookListSearchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{


            override fun onQueryTextChange(p0: String?): Boolean {
                val search = p0!!.lowercase(Locale.getDefault())
                if(search.isNotEmpty()){
                    var filter = ArrayList<Books>()
                    bookArrayList.forEach{
                        if(it is Books){
                            if(it.bookName.lowercase().contains(search)){
                                filter.add(it)
                            }
                        }
                    }
                    adapter.items=filter
                    adapter.notifyDataSetChanged()
                }
                else{
                    adapter.items=temp
                    adapter.notifyDataSetChanged()
                }
                return false
            }
            override fun onQueryTextSubmit(p0: String?): Boolean {
                val search = p0!!.lowercase(Locale.getDefault())
                var filter = ArrayList<Books>()
                bookArrayList.forEach{
                    if(it is Books){
                        if(it.bookName.lowercase().contains(search)){
                            filter.add(it)
                        }
                    }
                }
                adapter.items=filter
                adapter.notifyDataSetChanged()
                return false
            }
        })
    }
    fun fetchData(){
        for(i in bookName.indices){
            val book = Books(bookName[i],links[i])
            bookArrayList.add(book)
        }
    }

    override fun onClick(item: Books) {

        val intent = Intent(context,Downloader::class.java)
        intent.putExtra("title",item.bookName)
        intent.putExtra("link",item.link)
        startActivity(intent)


    }
}