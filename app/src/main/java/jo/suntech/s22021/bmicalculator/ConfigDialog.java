package jo.suntech.s22021.bmicalculator;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class ConfigDialog extends DialogFragment {
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState){
        //ダイアログログビルダーを生成。
        AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());
        //ダイアログのタイトル設定
        builder.setTitle(R.string.dialog_title);
        //ダイアログのメッセージを設定
        builder.setMessage(R.string.dialog_msg);
        //Positive Buttonを設定

        builder.setNegativeButton(R.string.dialog_btn_ng, new DialogButtonClickListener());
        //ダイアログオブジェクトを生成し、リターン
        AlertDialog dialog = builder.create();
        return dialog;

    }
    private class DialogButtonClickListener implements DialogInterface.OnClickListener{
        @Override
        public void onClick(DialogInterface dialog, int which) {

            //msg = getString(R.string.dialog_ng_toast);
        }
    }
}
