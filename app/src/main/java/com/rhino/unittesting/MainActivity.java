package com.rhino.unittesting;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.rhino.unittesting.databinding.ActivityMainBinding;

import java.util.regex.Pattern;

/**
 * @author LuoLin
 * @since Create on 2018/6/7.
 */
public class MainActivity extends AppCompatActivity {

    public ActivityMainBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String url = getIntent().getStringExtra("url");
        Log.d("RHINO", "url： " + url);

        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        mBinding.save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String projectName = mBinding.edit.getText().toString();
                if (isProjectNameValid(projectName)) {
                    Log.d("RHINO", "正确的工程名称： " + projectName);
                    mBinding.project.append(TextUtils.isEmpty(projectName) ? "" : projectName + "\n");
                } else {
                    Log.e("RHINO", "工程名称错误： " + projectName);
                    Toast.makeText(getApplicationContext(),
                            "无效工程名称，名称需要包含电压等级，如：四川500KV变电项目",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    /**
     * 工程名称是否有效，必须包含电压等级，如：四川500KV变电项目
     *
     * @param name 工程名称
     * @return true 有效
     */
    private boolean isProjectNameValid(@NonNull String name) {
        String lowName = name.toLowerCase();
        String kvRegex = ".*[0-9]+kv.*";
        String vRegex = ".*[0-9]+v.*";
        return Pattern.compile(kvRegex).matcher(lowName).matches()
                || Pattern.compile(vRegex).matcher(lowName).matches();
    }

}
