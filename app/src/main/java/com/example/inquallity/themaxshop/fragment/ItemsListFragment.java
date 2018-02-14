package com.example.inquallity.themaxshop.fragment;

import android.app.Fragment;
import android.os.Bundle;
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
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Inquallity on 05-Feb-18.
 */

public class ItemsListFragment extends Fragment implements ItemsListAdapter.OnCardClickListener {

    @BindView(R.id.rv_list_item) RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private ItemsListAdapter mItemsListAdapter;
    private List<Item> mItemList = new ArrayList<>();
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

        initializeData(i);

        mLayoutManager = new LinearLayoutManager(view.getContext());
        mItemsListAdapter = new ItemsListAdapter(mItemList);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mItemsListAdapter.setOnCardClickListener(this);
        mRecyclerView.setAdapter(mItemsListAdapter);
    }

    @Override
    public void onCardClick(View view, String title, int imgRes) {
        Fragment fragment = new ItemFragment();
        Bundle bundle = new Bundle();
        bundle.putString("KEY_TITLE", title);
        bundle.putInt("KEY_IMG_RES", imgRes);
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

    private void initializeData(int i) {
        switch (i) {
            case 1:
                initializeClassicFlowerList();
                break;
            case 2:
                initializeOriginFlowerList();
                break;
            case 3:
                initializeRoundBouquetList();
                break;
            case 4:
                initializeVerticalBouquetList();
                break;
            case 5:
                initializeOriginBouquetList();
                break;
            case 6:
                initializeFlowerBasketList();
                break;
            case 7:
                initializeHousePlantList();
                break;
            case 8:
                initializeOpenSoilPlantList();
                break;
            default:
                mItemList.add(new Item("Астра", "123", R.drawable.aster));
        }
    }

    private void initializeClassicFlowerList() {
        ((AppCompatActivity)(getActivity())).getSupportActionBar().setTitle(R.string.sub_title_classic);
        mItemList.add(new Item("Хризантема", "137", R.drawable.chrysanthemum));
        mItemList.add(new Item("Незабудка", "200", R.drawable.forget_me_not));
        mItemList.add(new Item("Гербера", "200", R.drawable.gerbera));
        mItemList.add(new Item("Гладиолус", "200", R.drawable.gladiolus));
        mItemList.add(new Item("глориоза", "200", R.drawable.gloriosa));
        mItemList.add(new Item("Гиацинт", "200", R.drawable.hyacinth));
        mItemList.add(new Item("Лилия", "200", R.drawable.lily));
        mItemList.add(new Item("Ландыш", "200", R.drawable.may_lily));
        mItemList.add(new Item("Нарцисс", "200", R.drawable.narcissus));
        mItemList.add(new Item("Орхидея", "200", R.drawable.orchid));
        mItemList.add(new Item("Астра", "123", R.drawable.aster));
        mItemList.add(new Item("Пион", "200", R.drawable.peony));
        mItemList.add(new Item("Роза", "200", R.drawable.rose));
        mItemList.add(new Item("Подсолнух", "200", R.drawable.sunflower));
        mItemList.add(new Item("Тюльпан", "200", R.drawable.tulip));
    }

    private void initializeOriginFlowerList() {
        ((AppCompatActivity)(getActivity())).getSupportActionBar().setTitle(R.string.sub_title_original);
        mItemList.add(new Item("Амарилис", "123", R.drawable.amaryllis));
        mItemList.add(new Item("Антуриум", "200", R.drawable.anthurium));
        mItemList.add(new Item("Антирринум", "123", R.drawable.antirrinum));
        mItemList.add(new Item("Аквиледжия", "200", R.drawable.aquilegia));
        mItemList.add(new Item("Кампанула", "200", R.drawable.campanula));
        mItemList.add(new Item("Карнатион", "123", R.drawable.carnation));
        mItemList.add(new Item("Дельфиниум", "200", R.drawable.delphinium));
        mItemList.add(new Item("Диантус", "123", R.drawable.dianthus_barbatus));
        mItemList.add(new Item("Цветок", "137", R.drawable.fleur_de_lis));
        mItemList.add(new Item("Ранукулюс", "200", R.drawable.ranunculus));
        mItemList.add(new Item("Галантус", "123", R.drawable.galanthus));
        mItemList.add(new Item("Гентиан", "137", R.drawable.gentian));
        mItemList.add(new Item("Гилли", "200", R.drawable.gillyflower));
        mItemList.add(new Item("Гидра", "200", R.drawable.hydrangea));
        mItemList.add(new Item("Латур", "200", R.drawable.latyrus));
        mItemList.add(new Item("Лузиан", "200", R.drawable.lysianthus));
        mItemList.add(new Item("Мускари", "200", R.drawable.muscari));
        mItemList.add(new Item("Тумерик", "200", R.drawable.turmeric));
    }

    private void initializeRoundBouquetList() {
        ((AppCompatActivity)(getActivity())).getSupportActionBar().setTitle(R.string.sub_title_round_bouquet);
        mItemList.add(new Item("Круглый букет 1", "123", R.drawable.round_bouquet));
        mItemList.add(new Item("Круглый букет 2", "123", R.drawable.round_bouquet_2));
        mItemList.add(new Item("Круглый букет 3", "123", R.drawable.round_bouquet_3));
        mItemList.add(new Item("Круглый букет 4", "123", R.drawable.round_bouquet_4));
        mItemList.add(new Item("Круглый букет 5", "123", R.drawable.round_bouquet_5));
        mItemList.add(new Item("Круглый букет 6", "123", R.drawable.round_bouquet_6));
        mItemList.add(new Item("Круглый букет 7", "123", R.drawable.round_bouquet_7));
        mItemList.add(new Item("Круглый букет 8", "123", R.drawable.round_bouquet_8));
    }

    private void initializeVerticalBouquetList() {
        ((AppCompatActivity)(getActivity())).getSupportActionBar().setTitle(R.string.sub_title_vertical_bouquet);
        mItemList.add(new Item("Вертикальный букет 2", "123", R.drawable.vertical_bouquet_2));
        mItemList.add(new Item("Вертикальный букет 3", "123", R.drawable.vertical_bouquet_3));
        mItemList.add(new Item("Вертикальный букет 4", "123", R.drawable.vertical_bouquet_4));
        mItemList.add(new Item("Вертикальный букет 5", "123", R.drawable.vertical_bouquet_5));
        mItemList.add(new Item("Вертикальный букет 6", "123", R.drawable.vertical_bouquet_6));
        mItemList.add(new Item("Вертикальный букет 7", "123", R.drawable.vertical_bouquet_7));
    }

    private void initializeOriginBouquetList() {
        ((AppCompatActivity)(getActivity())).getSupportActionBar().setTitle(R.string.sub_title_original_bouquet);
        mItemList.add(new Item("Оригинальный букет 1", "137", R.drawable.original_bouquets));
        mItemList.add(new Item("Оригинальный букет 2", "137", R.drawable.original_bouquets_2));
        mItemList.add(new Item("Оригинальный букет 3", "137", R.drawable.original_bouquets_3));
        mItemList.add(new Item("Оригинальный букет 4", "137", R.drawable.original_bouquets_4));
        mItemList.add(new Item("Оригинальный букет 5", "137", R.drawable.original_bouquets_5));
        mItemList.add(new Item("Оригинальный букет 6", "137", R.drawable.original_bouquets_6));
        mItemList.add(new Item("Оригинальный букет 7", "137", R.drawable.original_bouquets_7));
        mItemList.add(new Item("Оригинальный букет 8", "123", R.drawable.dutch_bouquets_2));
        mItemList.add(new Item("Оригинальный букет 9", "137", R.drawable.dutch_bouquets_3));
        mItemList.add(new Item("Оригинальный букет 10", "200", R.drawable.dutch_bouquets_4));
        mItemList.add(new Item("Оригинальный букет 11", "123", R.drawable.dutch_bouquets_5));
    }

    private void initializeFlowerBasketList() {
        ((AppCompatActivity)(getActivity())).getSupportActionBar().setTitle(R.string.sub_title_flower_basket);
        mItemList.add(new Item("Цветочная корзина 2", "123", R.drawable.flower_basket_2));
        mItemList.add(new Item("Цветочная корзина 3", "137", R.drawable.flower_basket_3));
        mItemList.add(new Item("Цветочная корзина 4", "200", R.drawable.flower_basket_4));
        mItemList.add(new Item("Цветочная корзина 5", "123", R.drawable.flower_basket_5));
        mItemList.add(new Item("Цветочная корзина 6", "137", R.drawable.flower_basket_6));
        mItemList.add(new Item("Цветочная корзина 7", "137", R.drawable.flower_basket_7));
        mItemList.add(new Item("Цветочная корзина 8", "137", R.drawable.flower_basket_8));
        mItemList.add(new Item("Цветочная корзина 9", "137", R.drawable.flower_basket_9));
        mItemList.add(new Item("Цветочная корзина 10", "137", R.drawable.flower_basket_10));
    }

    private void initializeHousePlantList() {
        ((AppCompatActivity)(getActivity())).getSupportActionBar().setTitle(R.string.sub_title_house_plant);
        mItemList.add(new Item("Амариллис", "123", R.drawable.hp_amaryllis));
        mItemList.add(new Item("Антуриум", "137", R.drawable.hp_anthurium));
        mItemList.add(new Item("Араукария", "200", R.drawable.hp_araucaria));
        mItemList.add(new Item("Асплениум", "123", R.drawable.hp_asplenium));
        mItemList.add(new Item("Азалия", "137", R.drawable.hp_azalea));
        mItemList.add(new Item("Бегония", "200", R.drawable.hp_begonia));
        mItemList.add(new Item("Каламондин", "123", R.drawable.hp_calamondin));
        mItemList.add(new Item("Калатея", "137", R.drawable.hp_calathea));
        mItemList.add(new Item("Лимон", "200", R.drawable.hp_citrus));
        mItemList.add(new Item("Кливия", "123", R.drawable.hp_clivia));
        mItemList.add(new Item("Кодиеум", "137", R.drawable.hp_codiaeum));
        mItemList.add(new Item("Крассула", "200", R.drawable.hp_crassula));
        mItemList.add(new Item("Артишок", "123", R.drawable.hp_cynara));
        mItemList.add(new Item("Орхидея Дендробиум ", "137", R.drawable.hp_dendrobium_nobile));
        mItemList.add(new Item("Дипладения", "123", R.drawable.hp_dipladenia));
        mItemList.add(new Item("Гибискус", "200", R.drawable.hp_hibiscus));
        mItemList.add(new Item("Каланхоэ", "200", R.drawable.hp_kalanchoe));
        mItemList.add(new Item("Нарцисс", "200", R.drawable.hp_narcissus));
        mItemList.add(new Item("Нертера", "200", R.drawable.hp_nertera));
        mItemList.add(new Item("Орхидея Онцидиум", "200", R.drawable.hp_oncidium));
    }

    private void initializeOpenSoilPlantList() {
        ((AppCompatActivity)(getActivity())).getSupportActionBar().setTitle(R.string.sub_title_open_soil);
        mItemList.add(new Item("Калиброхия", "123", R.drawable.os_calibrochia));
        mItemList.add(new Item("Кампанула", "137", R.drawable.os_campanula));
        mItemList.add(new Item("Хризантема", "200", R.drawable.os_chrysanthemum));
        mItemList.add(new Item("Кизил цветущий", "123", R.drawable.os_cornus_florida));
        mItemList.add(new Item("Купрессус Голдкрест", "137", R.drawable.os_cupressus_goldcrest));
        mItemList.add(new Item("Гайлардия", "200", R.drawable.os_gaillardia));
        mItemList.add(new Item("Вереск", "123", R.drawable.os_heather));
        mItemList.add(new Item("Гортензия", "137", R.drawable.os_hydrangea));
        mItemList.add(new Item("Лаванда", "200", R.drawable.os_lavender));
        mItemList.add(new Item("Мускари", "137", R.drawable.os_muscari));
        mItemList.add(new Item("Орнитогалум", "200", R.drawable.os_ornithogalum));
        mItemList.add(new Item("Остеоспермум", "123", R.drawable.os_osteospermum));
        mItemList.add(new Item("Петуния", "137", R.drawable.os_petunia));
        mItemList.add(new Item("Чубушник", "200", R.drawable.os_philadelphus));
        mItemList.add(new Item("Пицея Пунгенс Глаука", "123", R.drawable.os_picea_pungens_glauca));
        mItemList.add(new Item("Роза", "137", R.drawable.os_rose_soil));
        mItemList.add(new Item("Ива", "200", R.drawable.os_salix));
        mItemList.add(new Item("Подсолнух", "200", R.drawable.os_sunflower_soil));
    }
}
