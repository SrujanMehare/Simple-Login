import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.simplelogin.Model.UserModelClass
import com.example.simplelogin.R
import kotlinx.android.synthetic.main.item_user_layout.view.*


class UserAdapter(val context: Context, val items: ArrayList<UserModelClass>) :
    RecyclerView.Adapter<UserAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.item_user_layout,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val item = items[position]

        holder.tvId.text = item.id
        holder.tvName.text = item.name
        holder.tvEmail.text = item.email
        holder.tvAge.text = item.age.toString()

    }

    override fun getItemCount(): Int {
        return items.size
    }


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvId = view.tv_id
        val tvName = view.tv_name
        val tvEmail = view.tv_email
        val tvAge = view.tv_age

    }
}