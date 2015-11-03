/*
 * Materialize - Materialize all those not material
 * Copyright (C) 2015  XiNGRZ <xxx@oxo.ooo>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package ooo.oxo.apps.materialize.util;

import android.support.v7.util.SortedList;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.util.SortedListAdapterCallback;

public abstract class SortedListAdapter<T, VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> {

    public final SortedList<T> data;

    public SortedListAdapter(Class<T> type) {
        this.data = new SortedList<>(type, new SortedListAdapterCallback<T>(this) {
            @Override
            public int compare(T o1, T o2) {
                return SortedListAdapter.this.compare(o1, o2);
            }

            @Override
            public boolean areContentsTheSame(T oldItem, T newItem) {
                return SortedListAdapter.this.areContentsTheSame(oldItem, newItem);
            }

            @Override
            public boolean areItemsTheSame(T item1, T item2) {
                return SortedListAdapter.this.areItemsTheSame(item1, item2);
            }
        });
    }

    @Override
    public final int getItemCount() {
        return data.size();
    }

    protected abstract int compare(T o1, T o2);

    protected abstract boolean areContentsTheSame(T oldItem, T newItem);

    protected abstract boolean areItemsTheSame(T item1, T item2);

}
