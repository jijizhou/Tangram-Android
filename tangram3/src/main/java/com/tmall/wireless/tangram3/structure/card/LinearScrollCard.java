/*
 * MIT License
 *
 * Copyright (c) 2018 Alibaba Group
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.tmall.wireless.tangram3.structure.card;

import android.support.annotation.Nullable;

import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.layout.GridLayoutHelper;
import com.tmall.wireless.tangram3.dataparser.concrete.Card;
import com.tmall.wireless.tangram3.structure.BaseCell;
import com.tmall.wireless.tangram3.structure.cell.LinearScrollCell;

import java.util.Collections;
import java.util.List;

/**
 * Created by Kunlun on 9/17/16.
 */
public class LinearScrollCard extends Card {
    private static final String LOG_TAG = "LinearScrollCard";

    public LinearScrollCell cell = new LinearScrollCell();

    @Override
    public void setCells(@Nullable List<BaseCell> cells) {
        if (cells == null || cells.isEmpty()) {
            super.setCells(null);
        } else {
            cell.setCells(cells);
            super.setCells(Collections.<BaseCell>singletonList(cell));
        }
    }

    @Nullable
    @Override
    public LayoutHelper convertLayoutHelper(@Nullable LayoutHelper oldHelper) {
        GridLayoutHelper helper = new GridLayoutHelper(1);
        helper.setItemCount(getCells().size());
        if (style != null && !Float.isNaN(style.aspectRatio)) {
            helper.setAspectRatio(style.aspectRatio);
        }
        return helper;
    }
}
