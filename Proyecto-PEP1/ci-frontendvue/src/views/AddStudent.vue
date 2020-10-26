<template>
    <div class="new">
        <el-container>
            <el-main>
                <NewStudent/>
            </el-main>
        </el-container>
    </div>
</template>

<script>

// @ is an alias to /src

import NewStudent from '@/components/NewStudent.vue'

export default{
    name: 'new',
    components:{
        NewStudent,
    },
}
</script>
