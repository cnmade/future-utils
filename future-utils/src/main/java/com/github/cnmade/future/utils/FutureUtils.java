package com.github.cnmade.future.utils;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * This class is aimed at simplifying work with {@code CompletableFuture}.
 */
public class FutureUtils {

    /**
     * Return a future that represents the completion of the futures in the provided list.
     *
     * @param futures futures to wait for
     * @return a new CompletableFuture that is completed when all of the given CompletableFutures complete
     */

    //入参是一个CompletableFuture的 列表，函数作用是把整个列表都加入join（也就是会让他们都执行，等全部完毕）
    public static CompletableFuture<Void> waitForAll(List<? extends CompletableFuture<?>> futures) {
        return CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));
    }

    /**
     * Return a future that represents the completion of any future in the provided list.
     *
     * @param futures futures to wait any
     * @return a new CompletableFuture that is completed when any of the given CompletableFutures complete
     */
    //入参是一个CompletableFuture的 列表，函数作用是把整个列表都加入join（也就是会让他们都执行，等任意一个完毕）
    public static CompletableFuture<Object> waitForAny(List<? extends CompletableFuture<?>> futures) {
        return CompletableFuture.anyOf(futures.toArray(new CompletableFuture[0]));
    }
}