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
                "1、用户注册成功后，简书将给予每个用户一个用户帐号及相应的密码，该用户帐号和密码由用户负责保管；用户应当对以其用户帐号进行的所有活动和事件负法律责任。\n" +
                "\n" +
                "2、用户须对在简书的注册信息的真实性、合法性、有效性承担全部责任，用户不得冒充他人；不得利用他人的名义发布任何信息；不得恶意使用注册帐号导致其他用户误认； 任何机构或个人注册和使用的互联网用户账号名称，不得有下列情形：\n" +
                "（一）违反宪法或法律法规规定的；\n" +
                "（二）危害国家安全，泄露国家秘密，颠覆国家政权，破坏国家统一的；\n" +
                "（三）损害国家荣誉和利益的，损害公共利益的；\n" +
                "（四）煽动民族仇恨、民族歧视，破坏民族团结的；\n" +
                "（五）破坏国家宗教政策，宣扬邪教和封建迷信的；\n" +
                "（六）散布谣言，扰乱社会秩序，破坏社会稳定的；\n" +
                "（七）散布淫秽、色情、赌博、暴力、凶杀、恐怖或者教唆犯罪的；\n" +
                "（八）侮辱或者诽谤他人，侵害他人合法权益的；\n" +
                "（九）含有法律、行政法规禁止的其他内容的。\n" +
                "\n" +
                "作者：简书\n" +
                "链接：https://www.jianshu.com/p/c44d171298ce\n" +
                "來源：简书\n" +
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
