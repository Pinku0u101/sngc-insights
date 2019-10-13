<template>
    <div class="sngc">
        <h2>Hi {{account.user.firstName}}!</h2>
        <p>Welcome To SNGC Insights</p>
        <p>DashBoard will be coming soon. Please fill form data</p>
        <em v-if="users.loading">Loading users...</em>
        <span v-if="users.error" class="text-danger">ERROR: {{users.error}}</span>
        <p>
            <router-link to="/login" class="router-link">Logout</router-link>
        </p>
    </div>
</template>

<script>
import { mapState, mapActions } from 'vuex'

export default {
    computed: {
        ...mapState({
            account: state => state.account,
            users: state => state.users.all
        })
    },
    created () {
        this.getAllUsers();
    },
    methods: {
        ...mapActions('users', {
            getAllUsers: 'getAll',
            deleteUser: 'delete'
        })
    }
};
</script>