package com.imobile3.groovypayments.ui.orderentry;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.imobile3.groovypayments.R;
import com.imobile3.groovypayments.data.model.Product;
import com.imobile3.groovypayments.manager.CartManager;
import com.imobile3.groovypayments.rules.CurrencyRules;
import com.imobile3.groovypayments.ui.BaseActivity;
import com.imobile3.groovypayments.ui.adapter.ProductListAdapter;
import com.imobile3.groovypayments.ui.checkout.CheckoutActivity;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Locale;

public class OrderEntryActivity extends BaseActivity {

    private OrderEntryViewModel mViewModel;
    private ProductListAdapter mProductListAdapter;
    private RecyclerView mProductListRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order_entry_activity);
        setUpMainNavBar();

        mProductListAdapter = new ProductListAdapter(this,
                new ArrayList<>(),
                new ProductListAdapter.AdapterCallback() {
                    @Override
                    public void onProductClick(Product product) {
                        handleProductClick(product);
                    }
                });
        mProductListRecyclerView = findViewById(R.id.list_products);
        mProductListRecyclerView.setAdapter(mProductListAdapter);
        mProductListRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        loadProducts();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    @Override
    protected void setUpMainNavBar() {
        super.setUpMainNavBar();
        mMainNavBar.showBackButton();
        mMainNavBar.showTitle(new CurrencyRules()
                .getCartTotal(CartManager.getInstance().getCart(), Locale.US));
        mMainNavBar.showSubtitle(getString(R.string.order_entry_subtitle));
        mMainNavBar.showCheckoutButton();
        mMainNavBar.getCheckoutButton().setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        handleCheckoutClick();
                    }
                });
    }

    @Override
    protected void initViewModel() {
        mViewModel = ViewModelProviders.of(this, new OrderEntryViewModelFactory())
                .get(OrderEntryViewModel.class);
    }

    @NonNull
    private OrderEntryViewModel getViewModel() {
        return mViewModel;
    }

    private void loadProducts() {
        getViewModel().getProducts()
                .observe(this, data -> mProductListAdapter.setItems(data));
    }

    private void handleProductClick(@NonNull Product product) {
        // TODO: Handle product click. Example: Add product to the cart.
    }

    private void handleCheckoutClick() {
        // TODO: Check whether the order total is $0.00.
        startActivity(new Intent(this, CheckoutActivity.class));
    }
}
