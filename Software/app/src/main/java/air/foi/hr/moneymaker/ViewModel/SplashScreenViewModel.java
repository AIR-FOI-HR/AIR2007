package air.foi.hr.moneymaker.ViewModel;

import android.content.Context;
import android.util.Log;

import androidx.lifecycle.ViewModel;

import java.util.List;

import air.foi.hr.core.database.MyDatabase;
import air.foi.hr.core.entiteti.KategorijaTransakcije;
import air.foi.hr.core.entiteti.Korisnik;
import air.foi.hr.core.modul.kategorije.CategoryImplementor;
import eu.airmoneymaker.rest.RestApiImplementor;
import eu.airmoneymaker.rest.RetrofitInstance;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class SplashScreenViewModel extends ViewModel {
    private Context context;
    private MyDatabase baza;

    public void konstruktor(Context context){
        this.context=context;
        this.baza=MyDatabase.getInstance(this.context);
    }
    private boolean ProvjeraPostojanostKategorijaUBazi(){
        return MyDatabase.getInstance(context).getKategorijaTransakcijeDAO().DohvatiSveKategorijeTransakcije().size()>0?true:false;
    }
    public void NapuniBazu(){
        if(!ProvjeraPostojanostKategorijaUBazi()){
            Retrofit r= RetrofitInstance.getInstance();
            RestApiImplementor api=r.create(RestApiImplementor.class);
            final Call<List<KategorijaTransakcije>> pozivUnosa = api.DohvatiSveKategorijeTransakcije();
            pozivUnosa.enqueue(new Callback<List<KategorijaTransakcije>>() {
                @Override
                public void onResponse(Call<List<KategorijaTransakcije>> call, Response<List<KategorijaTransakcije>> response) {
                    for(KategorijaTransakcije kt: response.body()){
                        Log.e("KategorijaUnso",kt.getCategoryName()+" "+kt.getCategoryIcon());
                        MyDatabase.getInstance(context).getKategorijaTransakcijeDAO().UnosKategorijeTransakcije(kt);
                    }
                }

                @Override
                public void onFailure(Call<List<KategorijaTransakcije>> call, Throwable t) {
                }
            });
        }
    }
}
