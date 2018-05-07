package tuyenmanucian.e_flashcard.Adapter;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import tuyenmanucian.e_flashcard.R;
import tuyenmanucian.e_flashcard.models.VerbsBQT;

/**
 * Created by Admin on 3/27/2018.
 */

public class AdapterVerb extends ArrayAdapter<VerbsBQT> {
    private Activity activity;
    int stt;
    ArrayList<VerbsBQT> verbsBQTS;

    public AdapterVerb(Activity context, int resource, ArrayList<VerbsBQT> objects) {
        super(context, resource, objects);
        this.activity = context;
        this.stt = resource;
        this.verbsBQTS = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = activity.getLayoutInflater();
            convertView = inflater.inflate(stt, null);
        }
        VerbsBQT verbsBQT = verbsBQTS.get(position);
        TextView tv_stt = (TextView) convertView.findViewById(R.id.tv_stt);
        TextView tv_verbs = (TextView) convertView.findViewById(R.id.tv_verbs);
        TextView tv_verb_QKD = (TextView) convertView.findViewById(R.id.tv_verb_QKD);
        TextView tv_verb_QKPT = (TextView) convertView.findViewById(R.id.tv_verb_QKPT);
        TextView Nghia = (TextView) convertView.findViewById(R.id.Nghia);

        tv_stt.setText(verbsBQT.getSTT());
        tv_verbs.setText(verbsBQT.getTuNguyenMau());
        tv_verb_QKD.setText(verbsBQT.getQuaKhuDon());
        tv_verb_QKPT.setText(verbsBQT.getQuaKhuPhanTu());
        Nghia.setText(verbsBQT.getNghiaCuaTu());
        return convertView;
    }
}
