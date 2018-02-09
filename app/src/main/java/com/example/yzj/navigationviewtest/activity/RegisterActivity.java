package com.example.yzj.navigationviewtest.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.example.yzj.navigationviewtest.R;
import com.example.yzj.navigationviewtest.utils.MyDialog;
import com.example.yzj.navigationviewtest.utils.ToastUtil;

public class RegisterActivity extends AppCompatActivity {
    private CheckBox mCheckBox;
    private AppCompatButton mRegister;
    private TextView mUserRead;
    private TextView message;

    private MyDialog myDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mCheckBox = (CheckBox) findViewById(R.id.checkBox);

        mRegister = (AppCompatButton) findViewById(R.id.register);
        mRegister.setEnabled(false);//设置按钮默认不可点击
        mRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ToastUtil.showToast(RegisterActivity.this, "注册成功");
                finish();
            }
        });

        mCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    mRegister.setClickable(true);   //可点击
                    mRegister.setEnabled(true);     //设置样式
                } else {
                    mRegister.setClickable(false);
                    mRegister.setEnabled(false);
                }
            }
        });

        mUserRead = (TextView) findViewById(R.id.tv_user_read);
        setmUserRead();

        mUserRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showProtocol();
            }
        });

    }

    private void setmUserRead(){
        SpannableStringBuilder builder = new SpannableStringBuilder(mUserRead.getText().toString());
        ForegroundColorSpan orangeSpan = new ForegroundColorSpan(Color.parseColor("#ff770d"));
        UnderlineSpan lineSpan = new UnderlineSpan();
        builder.setSpan(lineSpan,9,13, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);  //下划线
        builder.setSpan(orangeSpan,9,13, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);  //字体颜色

        mUserRead.setText(builder);
    }

    //显示协议
    private void showProtocol(){
        myDialog = new MyDialog(RegisterActivity.this);
        myDialog.setTitle("用户协议");
        myDialog.setMessage("使用规则\n" +
                "\n" +
                "1、阿斯加德哈吉斯多久啊打劫卡三点后武汉东湖大厦将颠文档爱仕达好是的骄傲可视电话卡话费卡技术服务为of哈手机号打发时间肯定会华盛顿加安顺家闪电发货安顺就。\n" +
                "\n" +
                "2、阿萨德黄金卡收到客户手机的黄金卡手机打开哈时间快点哈手机客户登记卡萨丁阿莎手机客户端阿萨德加安顺是的金卡和健康三很大速度户外东屋U盾哈U盾和安徽省的就肯定好看是的啥几点回家喀什佳世客动环监控暗示的机会啊时间快点哈时间肯定会睡觉啊很大手机客户大时代阿斯加德黄金卡：\n" +
                "（一）换手机卡活动卡仕达数据库的灰色空间；\n" +
                "（二）啊实打实肯定gas单个哈师大gas得根据噶伤筋动骨；\n" +
                "（三）阿萨德干哈施工队就是的gas好的噶都改好；\n" +
                "（四）登记卡收到卡就是搭好卡仕达时间快点哈数据库；\n" +
                "（五）抢我野怪为卫栖梧IE千万IE千万IE一千五为与为暗示健康大快速；\n" +
                "（六）高大上大概哈时间快点哈数据库的has抠脚大汉；\n" +
                "（七）为爱仕达卡拉斯科来得及奥斯卡来得及爱是快乐大家爱看领导；\n" +
                "（八）是个大帅哥大嘎达郭德纲阿萨德；\n" +
                "（九）UI安阳市抵押岁的压岁第一。\n" +
                "（十）换手机卡活动卡仕达数据库的灰色空间；\n" +
                "（十一）换手机卡活动卡仕达数据库的灰色空间；\n" +
                "（十二）啊实打实肯定gas单个哈师大gas得根据噶伤筋动骨；\n" +
                "（十三）阿萨德干哈施工队就是的gas好的噶都改好；\n" +
                "（十四）登记卡收到卡就是搭好卡仕达时间快点哈数据库；\n" +
                "（十五）抢我野怪为卫栖梧IE千万IE千万IE一千五为与为暗示健康大快速；\n" +
                "（十六）高大上大概哈时间快点哈数据库的has抠脚大汉；\n" +
                "（十七）为爱仕达卡拉斯科来得及奥斯卡来得及爱是快乐大家爱看领导；\n" +
                "（十八）是个大帅哥大嘎达郭德纲阿萨德；\n" +
                "（十九）UI安阳市抵押岁的压岁第一。\n" +
                "（二十）等哈沙水库的环境奥斯卡。\n" +
                "\n" +
                "作者：yzj\n" +
                "链接：https://www.yzj.com/\n" +
                "來源：东屋电气\n" +
                "著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。");
        myDialog.setYesOnclickListener("确定", new MyDialog.onYesOnclickListener() {
            @Override
            public void onYesClick() {
                myDialog.dismiss();
                mCheckBox.setChecked(true);
            }
        });
        myDialog.setNoOnclickListener("取消", new MyDialog.onNoOnclickListener() {
            @Override
            public void onNoClick() {
                myDialog.dismiss();
                mCheckBox.setChecked(false);
            }
        });
        myDialog.show();
    }

}
