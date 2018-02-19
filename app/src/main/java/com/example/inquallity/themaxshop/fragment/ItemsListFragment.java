package com.example.inquallity.themaxshop.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.inquallity.themaxshop.R;
import com.example.inquallity.themaxshop.adapter.ItemsListAdapter;
import com.example.inquallity.themaxshop.model.Item;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Inquallity on 05-Feb-18.
 */

public class ItemsListFragment extends Fragment implements ItemsListAdapter.OnCardClickListener {

    @BindView(R.id.rv_list_item)
    RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private ItemsListAdapter mItemsListAdapter = new ItemsListAdapter();

    private Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fmt_items_list, container, false);
    }

    @Override
    public void onViewCreated(final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        unbinder = ButterKnife.bind(this, view);

        final Bundle bundle = this.getArguments();
        int i = bundle.getInt("LIST_NUMBER");

        final List<Item> items = initializeData(i);

        mLayoutManager = new LinearLayoutManager(view.getContext());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mItemsListAdapter.setOnCardClickListener(this);
        mRecyclerView.setAdapter(mItemsListAdapter);
        mItemsListAdapter.changeItems(items);
    }

    @Override
    public void onCardClick(View view, String title, int imgRes, String price) {
        Fragment fragment = new ItemFragment();
        Bundle bundle = new Bundle();
        bundle.putString("KEY_TITLE", title);
        bundle.putInt("KEY_IMG_RES", imgRes);
        bundle.putString("KEY_PRICE", price);
        fragment.setArguments(bundle);
        getFragmentManager()
                .beginTransaction()
                .replace(R.id.fl_items_list_content, fragment)
                .addToBackStack(fragment.getClass().getName())
                .commit();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }

    private List<Item> initializeData(int position) {
        switch (position) {
            case 1:
                return initializeClassicFlowerList();
            case 2:
                return initializeOriginFlowerList();
            case 3:
                return initializeRoundBouquetList();
            case 4:
                return initializeVerticalBouquetList();
            case 5:
                return initializeOriginBouquetList();
            case 6:
                return initializeFlowerBasketList();
            case 7:
                return initializeHousePlantList();
            case 8:
                return initializeOpenSoilPlantList();
            default:
                return Collections.singletonList(new Item("Ландыш", "200 \u20BD", R.drawable.may_lily));
        }
    }

    @NonNull
    private List<Item> initializeClassicFlowerList() {
        final List<Item> items = new ArrayList<>();
        ((AppCompatActivity) (getActivity())).getSupportActionBar().setTitle(R.string.sub_title_classic);
        items.add(new Item("Хризантема", "90 \u20BD", R.drawable.chrysanthemum));
        items.add(new Item("Незабудка", "110 \u20BD", R.drawable.forget_me_not));
        items.add(new Item("Гербера", "130 \u20BD", R.drawable.gerbera));
        items.add(new Item("Гладиолус", "200 \u20BD", R.drawable.gladiolus));
        items.add(new Item("Гиацинт", "100 \u20BD", R.drawable.hyacinth));
        items.add(new Item("Лилия", "250 \u20BD", R.drawable.lily));
        items.add(new Item("Ландыш", "200 \u20BD", R.drawable.may_lily));
        items.add(new Item("Нарцисс", "50 \u20BD", R.drawable.narcissus));
        items.add(new Item("Орхидея", "1100 \u20BD", R.drawable.orchid));
        items.add(new Item("Астра", "100 \u20BD", R.drawable.aster));
        items.add(new Item("Пион", "250 \u20BD", R.drawable.peony));
        items.add(new Item("Роза", "190 \u20BD", R.drawable.rose));
        items.add(new Item("Подсолнух", "320 \u20BD", R.drawable.sunflower));
        items.add(new Item("Тюльпан", "60 \u20BD", R.drawable.tulip));
        items.add(new Item("Ирис", "170 \u20BD", R.drawable.fleur_de_lis));
        return items;
    }

    private List<Item> initializeOriginFlowerList() {
        final List<Item> items = new ArrayList<>();
        ((AppCompatActivity) (getActivity())).getSupportActionBar().setTitle(R.string.sub_title_original);
        items.add(new Item("Амарилис", "350 \u20BD", R.drawable.amaryllis));
        items.add(new Item("Аквиледжия", "200 \u20BD", R.drawable.aquilegia));
        items.add(new Item("Кампанула", "200 \u20BD", R.drawable.campanula));
        items.add(new Item("Карнатион", "120 \u20BD", R.drawable.carnation));
        items.add(new Item("Антуриум", "290 \u20BD", R.drawable.anthurium));
        items.add(new Item("Антирринум", "260 \u20BD", R.drawable.antirrinum));
        items.add(new Item("Дельфиниум", "345 \u20BD", R.drawable.delphinium));
        items.add(new Item("Диантус", "120 \u20BD", R.drawable.dianthus_barbatus));
        items.add(new Item("Ранукулюс", "250 \u20BD", R.drawable.ranunculus));
        items.add(new Item("Галантус", "550 \u20BD", R.drawable.galanthus));
        items.add(new Item("Гентиан", "320 \u20BD", R.drawable.gentian));
        items.add(new Item("Гилли", "390 \u20BD", R.drawable.gillyflower));
        items.add(new Item("Гидра", "350 \u20BD", R.drawable.hydrangea));
        items.add(new Item("Латур", "250 \u20BD", R.drawable.latyrus));
        items.add(new Item("Лузиан", "220 \u20BD", R.drawable.lysianthus));
        items.add(new Item("Мускари", "300 \u20BD", R.drawable.muscari));
        items.add(new Item("Тумерик", "250 \u20BD", R.drawable.turmeric));
        return items;
    }

    private List<Item> initializeRoundBouquetList() {
        final List<Item> items = new ArrayList<>();
        ((AppCompatActivity) (getActivity())).getSupportActionBar().setTitle(R.string.sub_title_round_bouquet);
        items.add(new Item("Феерия чувств", "3390 \u20BD", R.drawable.round_bouquet_1));
        items.add(new Item("Волшебство природы", "5520 \u20BD", R.drawable.round_bouquet_2));
        items.add(new Item("Седьмое небо", "3780 \u20BD", R.drawable.round_bouquet_3));
        items.add(new Item("Яркая фантазия", "4280 \u20BD", R.drawable.round_bouquet_4));
        items.add(new Item("Жемчужина", "3290 \u20BD", R.drawable.round_bouquet_5));
        items.add(new Item("Шарлотта", "3770 \u20BD", R.drawable.round_bouquet_6));
        items.add(new Item("Розовая пантера", "2890 \u20BD", R.drawable.round_bouquet_7));
        items.add(new Item("Весеннее настроение", "4120 \u20BD", R.drawable.round_bouquet_8));
        return items;
    }

    private List<Item> initializeVerticalBouquetList() {
        final List<Item> items = new ArrayList<>();
        ((AppCompatActivity) (getActivity())).getSupportActionBar().setTitle(R.string.sub_title_vertical_bouquet);
        items.add(new Item("История любви", "5800 \u20BD", R.drawable.vertical_bouquet_2));
        items.add(new Item("Капелька счастья", "4520 \u20BD", R.drawable.vertical_bouquet_3));
        items.add(new Item("Исполняющий желания", "3780 \u20BD", R.drawable.vertical_bouquet_4));
        items.add(new Item("Кремовое настроение", "5400 \u20BD", R.drawable.vertical_bouquet_5));
        items.add(new Item("Ласточка", "3500 \u20BD", R.drawable.vertical_bouquet_6));
        items.add(new Item("Лунный букет", "4230 \u20BD", R.drawable.vertical_bouquet_7));
        return items;
    }

    private List<Item> initializeOriginBouquetList() {
        final List<Item> items = new ArrayList<>();
        ((AppCompatActivity) (getActivity())).getSupportActionBar().setTitle(R.string.sub_title_original_bouquet);
        items.add(new Item("Нежнее нежного", "5120 \u20BD", R.drawable.original_bouquets));
        items.add(new Item("Новогоднее настроение", "4080 \u20BD", R.drawable.original_bouquets_2));
        items.add(new Item("Красота природы", "5100 \u20BD", R.drawable.original_bouquets_3));
        items.add(new Item("Нежные чувства", "2500 \u20BD", R.drawable.original_bouquets_4));
        items.add(new Item("Муза", "3150 \u20BD", R.drawable.original_bouquets_5));
        items.add(new Item("Яркое лето", "3700 \u20BD", R.drawable.original_bouquets_6));
        items.add(new Item("Розовая сказка", "2600 \u20BD", R.drawable.original_bouquets_7));
        items.add(new Item("Сладкое утро", "4900 \u20BD", R.drawable.dutch_bouquets_2));
        items.add(new Item("Солнечный свет", "4500 \u20BD", R.drawable.dutch_bouquets_3));
        items.add(new Item("Сияние", "4780 \u20BD", R.drawable.dutch_bouquets_4));
        items.add(new Item("Маленькая Леди", "3780 \u20BD", R.drawable.dutch_bouquets_5));
        return items;
    }

    private List<Item> initializeFlowerBasketList() {
        final List<Item> items = new ArrayList<>();
        ((AppCompatActivity) (getActivity())).getSupportActionBar().setTitle(R.string.sub_title_flower_basket);
        items.add(new Item("Нежное прикосновение", "4120 \u20BD", R.drawable.flower_basket_2));
        items.add(new Item("Вдохновение", "3780 \u20BD", R.drawable.flower_basket_3));
        items.add(new Item("Белые ночи", "3980 \u20BD", R.drawable.flower_basket_4));
        items.add(new Item("Вальс цветов", "4500 \u20BD", R.drawable.flower_basket_5));
        items.add(new Item("Воздушные мечты", "3100 \u20BD", R.drawable.flower_basket_6));
        items.add(new Item("Яркая вспышка", "4500 \u20BD", R.drawable.flower_basket_7));
        items.add(new Item("Ягодный десерт", "5000 \u20BD", R.drawable.flower_basket_8));
        items.add(new Item("Робкая надежда", "3970 \u20BD", R.drawable.flower_basket_9));
        items.add(new Item("Мелодия чувств", "3500 \u20BD", R.drawable.flower_basket_10));
        return items;
    }

    private List<Item> initializeHousePlantList() {
        final List<Item> items = new ArrayList<>();
        ((AppCompatActivity) (getActivity())).getSupportActionBar().setTitle(R.string.sub_title_house_plant);
        items.add(new Item("Амариллис", "330 \u20BD", R.drawable.hp_amaryllis));
        items.add(new Item("Антуриум", "1050 \u20BD", R.drawable.hp_anthurium));
        items.add(new Item("Араукария", "560 \u20BD", R.drawable.hp_araucaria));
        items.add(new Item("Асплениум", "540 \u20BD", R.drawable.hp_asplenium));
        items.add(new Item("Азалия", "470 \u20BD", R.drawable.hp_azalea));
        items.add(new Item("Бегония", "300 \u20BD", R.drawable.hp_begonia));
        items.add(new Item("Каламондин", "1500 \u20BD", R.drawable.hp_calamondin));
        items.add(new Item("Калатея", "900 \u20BD", R.drawable.hp_calathea));
        items.add(new Item("Лимон", "1700 \u20BD", R.drawable.hp_citrus));
        items.add(new Item("Кливия", "1100 \u20BD", R.drawable.hp_clivia));
        items.add(new Item("Кодиеум", "500 \u20BD", R.drawable.hp_codiaeum));
        items.add(new Item("Крассула", "450 \u20BD", R.drawable.hp_crassula));
        items.add(new Item("Артишок", "900 \u20BD", R.drawable.hp_cynara));
        items.add(new Item("Орхидея Дендробиум ", "1100 \u20BD", R.drawable.hp_dendrobium_nobile));
        items.add(new Item("Дипладения", "500 \u20BD", R.drawable.hp_dipladenia));
        items.add(new Item("Гибискус", "380 \u20BD", R.drawable.hp_hibiscus));
        items.add(new Item("Каланхоэ", "600 \u20BD", R.drawable.hp_kalanchoe));
        items.add(new Item("Нарцисс", "550 \u20BD", R.drawable.hp_narcissus));
        items.add(new Item("Нертера", "400 \u20BD", R.drawable.hp_nertera));
        items.add(new Item("Орхидея Онцидиум", "1500 \u20BD", R.drawable.hp_oncidium));
        return items;
    }

    private List<Item> initializeOpenSoilPlantList() {
        final List<Item> items = new ArrayList<>();
        ((AppCompatActivity) (getActivity())).getSupportActionBar().setTitle(R.string.sub_title_open_soil);
        items.add(new Item("Калиброхия", "500 \u20BD", R.drawable.os_calibrochia));
        items.add(new Item("Кампанула", "660 \u20BD", R.drawable.os_campanula));
        items.add(new Item("Хризантема", "360 \u20BD", R.drawable.os_chrysanthemum));
        items.add(new Item("Кизил цветущий", "200 \u20BD", R.drawable.os_cornus_florida));
        items.add(new Item("Купрессус Голдкрест", "460 \u20BD", R.drawable.os_cupressus_goldcrest));
        items.add(new Item("Гайлардия", "500 \u20BD", R.drawable.os_gaillardia));
        items.add(new Item("Вереск", "600 \u20BD", R.drawable.os_heather));
        items.add(new Item("Гортензия", "1300 \u20BD", R.drawable.os_hydrangea));
        items.add(new Item("Лаванда", "700 \u20BD", R.drawable.os_lavender));
        items.add(new Item("Мускари", "270 \u20BD", R.drawable.os_muscari));
        items.add(new Item("Орнитогалум", "420 \u20BD", R.drawable.os_ornithogalum));
        items.add(new Item("Остеоспермум", "300 \u20BD", R.drawable.os_osteospermum));
        items.add(new Item("Петуния", "450 \u20BD", R.drawable.os_petunia));
        items.add(new Item("Чубушник", "1300 \u20BD", R.drawable.os_philadelphus));
        items.add(new Item("Пицея Пунгенс Глаука", "850 \u20BD", R.drawable.os_picea_pungens_glauca));
        items.add(new Item("Роза", "700 \u20BD", R.drawable.os_rose_soil));
        items.add(new Item("Ива", "900 \u20BD", R.drawable.os_salix));
        items.add(new Item("Подсолнух", "950 \u20BD", R.drawable.os_sunflower_soil));
        return items;
    }
}
